package io.github.pactstart.poi;

import io.github.pactstart.poi.exception.POIParseException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class POIUtils {

    public static boolean isBlankRow(Row row) {
        Iterator<Cell> it = row.iterator();
        while (it.hasNext()) {
            Cell cell = it.next();
            if (cell.getCellTypeEnum() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    public static HSSFWorkbook createWorkbook(String sheetName, String[] headers) {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);
        HSSFRow row0 = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            String header = headers[i];
            HSSFCell cell = row0.createCell(i);
            cell.setCellValue(header);
        }
        return wb;
    }

    public static byte[] writeToBytes(Workbook wb, int cols) {
        for (int i = 0; i < cols; i++) {
            wb.getSheetAt(0).autoSizeColumn(i);
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            wb.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
            }
        }
        return out.toByteArray();
    }

    public static List<Map<String, Object>> readWorkbook(InputStream inputStream, BeanCellField[] fields,
                                                         int ignoreRows) {
        List<Map<String, Object>> rowDataList = new ArrayList<>();
        Workbook workbook = null;
        try {
            try {
                workbook = WorkbookFactory.create(inputStream);
            } catch (Exception e) {
                throw new POIParseException("文件不是有效Excel格式");
            }
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIt = sheet.rowIterator();
            short rowIndex = 0;
            int cellNum = 0;
            while (rowIt.hasNext()) {
                Row row = rowIt.next();
                if (rowIndex == 0) {
                    cellNum = row.getLastCellNum();
                }
                rowIndex++;
                // 忽略前面，并且忽略空行
                if (rowIndex <= ignoreRows || POIUtils.isBlankRow(row)) {
                    continue;
                }
                if (cellNum != fields.length) {
                    throw new POIParseException("文档模版不符");
                }
                Map<String, Object> rowData = new HashMap<String, Object>();
                // 遍历单元格
                for (short colIx = 0; colIx < cellNum; colIx++) {
                    Cell cell = row.getCell(colIx);
                    BeanCellField beanField = fields[colIx];
                    Object value = null;
                    try {
                        value = beanField.getValue(cell);
                        String name = beanField.getName();
                        rowData.put(name, value);
                    } catch (Exception e) {
                        String caption = beanField.getCaption();
                        throw new POIParseException("解析列[" + caption + "]出错,[第" + (rowIndex + 1) + "行,第"
                                + (colIx + 1) + "列],提示:" + e.getMessage());
                    }
                }
                rowDataList.add(rowData);
            }
            workbook.close();
        } catch (IOException e) {
            throw new POIParseException("文档解析错误");
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                }
            }
        }
        return rowDataList;
    }
}
