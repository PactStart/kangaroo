package io.github.pactstart.biz.common.dto;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PageResultDto<T> extends BaseDto{

    /**
     * 每页数据条数
     */
    private int pageSize;

    /**
     * 当前页
     */
    private int currentPage;

    /**
     * 总页数
     */
    private int totalPages;

    /**
     * 总数据数
     */
    private long totalRows;

    /**
     * 是否有下一页
     */
    private boolean hasNextPage;

    /**
     * 是否有前一页
     */
    private boolean hasPreviousPage;

    /**
     * 数据
     */
    private List<T> result;
    ;

    public PageResultDto(int pageSize, int currentPage, int totalPages, long totalRows, List<T> result) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalRows = totalRows;
        this.result = result;
        this.hasNextPage = currentPage < totalPages;
        this.hasPreviousPage = 1 < currentPage && currentPage < totalPages;
    }

}
