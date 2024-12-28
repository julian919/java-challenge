package com.julian.java_challenge.postcodes_service.dto;

public class GetPostcodesRequestDto {
    private int page;
    private int limit;

    public GetPostcodesRequestDto(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
