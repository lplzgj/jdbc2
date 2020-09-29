package com.csi.domain;

import java.util.List;

public class Page<T> {
    private int currentPage;//当前页
    private int pageSize;//一页显示多少数据
    private int totalData;//一页有多少数据
    private List<T> data;//查询结果

    public Page() {
    }

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getCurrentPage(){
        return currentPage;
    }

    public void setCurrentPage(int currentPage){
        this.currentPage=currentPage;
    }

    public int getPageSize(){
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalPageCount(){
        return this.totalData%this.pageSize==0?this.totalData/this.pageSize:this.totalData/this.pageSize+1;
    }

    public int prev(){
        return this.currentPage-1>0?this.currentPage-1:1;
    }

    public int next(){
        return this.currentPage+1<=getTotalPageCount()?this.currentPage+1:getTotalPageCount();
    }

    public int start(){
        return (this.currentPage-1)*this.pageSize;
    }

}
