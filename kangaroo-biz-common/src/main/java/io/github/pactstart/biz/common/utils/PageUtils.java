package io.github.pactstart.biz.common.utils;

import com.github.pagehelper.Page;
import io.github.pactstart.biz.common.dto.PageResultDto;

import java.util.List;

public class PageUtils {

    public static <T, E> PageResultDto<T> convert(Page<E> page, List<T> list) {

        return new PageResultDto<T>(page.getPageSize(), page.getPageNum(), page.getPages(), page.getTotal(), list);
    }

    public static <T, E> PageResultDto<T> convert(Page<E> page, Class<T> clazz) {

        return new PageResultDto<T>(page.getPageSize(), page.getPageNum(), page.getPages(), page.getTotal(), MapperUtils.mapList(page.getResult(), clazz));

    }
}
