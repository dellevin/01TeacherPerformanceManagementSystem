package com.tpms.utils;

import java.util.List;

public class PageTool {
    private int totalCount;//总数据量
    private int currentPage;//当前页码
    private int pageCount;//总页数
    private int lastPage;//上一页页码
    private int nextPage;//下一页页码
    private int startIndex;//起始下标
    private int pageSize;//每页数据量
    private List list;//保存分页数据

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    //构造方法只需要传递总数据量、当前页码、每页数据量，因为其余的分页信息，可以运算出来！
    public PageTool(int totalCount, String currentPage, int pageSize) {
        this.totalCount = totalCount;//初始化总数据量
        this.pageSize = pageSize;//初始化每页数据量
        initialCurrentPage(currentPage);
        initialPageCount();
        initialLastPage();
        initialNextPage();
        initialStartIndex();
    }

    //初始化起始下标
    private void initialStartIndex() {
        startIndex = (currentPage - 1) * pageSize;
    }

    //初始化下一页页码
    private void initialNextPage() {
        if (currentPage == pageCount) {
            nextPage = pageCount;
        } else {
            nextPage = currentPage + 1;
        }
    }

    //初始化上一页页码
    private void initialLastPage() {
        if (currentPage == 1) {
            lastPage = 1;
        } else {
            lastPage = currentPage - 1;
        }
    }

    //初始化总页码
    private void initialPageCount() {
        pageCount = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
    }

    //初始化当前页码
    private void initialCurrentPage(String currentPage) {
        if (currentPage != null) {
            this.currentPage = Integer.valueOf(currentPage);
        } else {
            this.currentPage = 1;
        }
    }

    public PageTool() {
    }

    @Override
    public String toString() {
        return "PageTool{" +
                "totalCount=" + totalCount +
                ", currentPage=" + currentPage +
                ", pageCount=" + pageCount +
                ", lastPage=" + lastPage +
                ", nextPage=" + nextPage +
                ", startIndex=" + startIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}
