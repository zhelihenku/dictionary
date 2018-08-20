package com.zhelihenku.dictionary.rest.modular.dictionary.dto;

/**
 * PageListParams
 *
 * @Auther: PhilWang
 * @Date: 2018/8/20 20:22
 */
public class PageListParams {

    /**
     * 页码
     */
    private Integer index;
    /**
     * 每页条数
     */
    private Integer pageSize;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageListParams{" +
                "index='" + index + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}
