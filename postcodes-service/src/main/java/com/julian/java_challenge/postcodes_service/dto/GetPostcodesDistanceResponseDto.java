package com.julian.java_challenge.postcodes_service.dto;

public class GetPostcodesDistanceResponseDto {
    private String distance;
    private String error;

    public GetPostcodesDistanceResponseDto(String distance, String error) {
        this.distance = distance;
        this.error = error;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
