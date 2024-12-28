package com.julian.java_challenge.postcodes_service.dto;

public class GetPostcodesDistanceRequestDto {
    private String postcode1;
    private String postcode2;

    public GetPostcodesDistanceRequestDto(String postcode1, String postcode2) {
        this.postcode1 = postcode1;
        this.postcode2 = postcode2;
    }

    public String getPostcode2() {
        return postcode2;
    }

    public void setPostcode2(String postcode2) {
        this.postcode2 = postcode2;
    }

    public String getPostcode1() {
        return postcode1;
    }

    public void setPostcode1(String postcode1) {
        this.postcode1 = postcode1;
    }
}
