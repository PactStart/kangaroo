package io.github.pactstart.poi;

import io.github.pactstart.poi.convert.ConvertFactory;
import io.github.pactstart.poi.convert.Converter;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class BeanCellField {

    private String name;

    private String caption;

    private CellValueType type;

    private Converter<Object, ?> converter;

    public BeanCellField(String name, String caption, CellValueType type, Class<? extends Converter<?, ?>> converter) {
        this.name = name;
        this.caption = caption;
        this.type = type;
        if (converter != null) {
            this.converter = ConvertFactory.getConverter(converter);
        }
    }

    public String getName() {
        return name;
    }

    public Object getValue(Cell cell) {
        Object value = null;
        if (cell != null) {
            if (type == CellValueType.String) {
                if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                    double num = cell.getNumericCellValue();
                    value = new NumberEval(num).getStringValue();
                } else {
                    value = cell.getStringCellValue();
                }
            } else if (type == CellValueType.Number) {
                value = cell.getNumericCellValue();
            } else if (type == CellValueType.Date) {
                value = cell.getDateCellValue();
            }
        }
        if (value != null && converter != null) {
            if (value instanceof String) {
                value = ((String) value).trim();
            }
            value = converter.convert(value);
        }
        return value;
    }

    public String getCaption() {
        return caption;
    }

    public CellValueType getType() {
        return type;
    }
}
