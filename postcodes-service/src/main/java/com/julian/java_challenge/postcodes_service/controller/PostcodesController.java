package com.julian.java_challenge.postcodes_service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julian.java_challenge.postcodes_service.dto.GetPostcodesDistanceRequestDto;
import com.julian.java_challenge.postcodes_service.dto.GetPostcodesDistanceResponseDto;
import com.julian.java_challenge.postcodes_service.dto.GetPostcodesRequestDto;
import com.julian.java_challenge.postcodes_service.dto.GetPostcodesResponseDto;
import com.julian.java_challenge.postcodes_service.model.Postcode;
import com.julian.java_challenge.postcodes_service.service.PostcodesService;

@RestController
@RequestMapping("/postcodes")
public class PostcodesController {

    private final PostcodesService postcodesService;

    public PostcodesController(PostcodesService postcodesService) {
        this.postcodesService = postcodesService;
    }

    @PostMapping
    public ResponseEntity<GetPostcodesResponseDto> getPostcodes(
            @RequestHeader(value = "x-user-id", required = false) String userId,
            @RequestHeader Map<String, String> object,
            @RequestBody GetPostcodesRequestDto getPostcodesRequestDto) {

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new GetPostcodesResponseDto("Unauthorized" + object));
        }

        try {
            Page<Postcode> postcodesPage = postcodesService.getPostcodes(getPostcodesRequestDto.getLimit(),
                    getPostcodesRequestDto.getPage());

            List<Postcode> posts = postcodesPage.getContent();

            int totalPages = postcodesPage.getTotalPages();

            GetPostcodesResponseDto successResponse = new GetPostcodesResponseDto(posts, totalPages, null);

            return ResponseEntity.ok(successResponse);
        }

        catch (RuntimeException e) {
            GetPostcodesResponseDto errorResponse = new GetPostcodesResponseDto(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/distance")
    public ResponseEntity<GetPostcodesDistanceResponseDto> getPostcodeDistance(
            @RequestBody GetPostcodesDistanceRequestDto getPostcodesDistanceRequestDto) {
        try {
            String distanceInKm = postcodesService.getPostcodesDistanceInKm(
                    getPostcodesDistanceRequestDto.getPostcode1(),
                    getPostcodesDistanceRequestDto.getPostcode2());

            GetPostcodesDistanceResponseDto successResponse = new GetPostcodesDistanceResponseDto(distanceInKm, null);

            return ResponseEntity.ok(successResponse);
        } catch (Exception e) {
            GetPostcodesDistanceResponseDto errorResponse = new GetPostcodesDistanceResponseDto(null, e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

}
