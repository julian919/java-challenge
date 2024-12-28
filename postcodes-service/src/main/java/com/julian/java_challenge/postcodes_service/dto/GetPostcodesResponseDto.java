package com.julian.java_challenge.postcodes_service.dto;

import java.util.List;

import com.julian.java_challenge.postcodes_service.model.Postcode;

public class GetPostcodesResponseDto {
    private List<Postcode> postcodes;
    private int totalPages;
    private String error;

    public GetPostcodesResponseDto(List<Postcode> postcodes, int totalPages, String error) {
        this.postcodes = postcodes;
        this.totalPages = totalPages;
        this.error = error;
    }

    public GetPostcodesResponseDto(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Postcode> getPostcodes() {
        return postcodes;
    }

    public void setPostcodes(List<Postcode> postcodes) {
        this.postcodes = postcodes;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
