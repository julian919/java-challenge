package com.julian.java_challenge.postcodes_service.dto;

public class UpdatePostcodesRequestDto {
    private String postcode;
    private Double latitude;
    private Double longitude;

    public UpdatePostcodesRequestDto(String postcode, Double latitude, Double longitude) {
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}