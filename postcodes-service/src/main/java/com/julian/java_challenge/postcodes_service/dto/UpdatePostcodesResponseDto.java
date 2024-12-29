package com.julian.java_challenge.postcodes_service.dto;

import com.julian.java_challenge.postcodes_service.model.Postcode;

public class UpdatePostcodesResponseDto {
    private Postcode postcode;
    private String error;

    public UpdatePostcodesResponseDto(Postcode postcode, String error) {
        this.postcode = postcode;
        this.error = error;
    }

    public Postcode getPostcode() {
        return postcode;
    }

    public void setPostcode(Postcode postcode) {
        this.postcode = postcode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
