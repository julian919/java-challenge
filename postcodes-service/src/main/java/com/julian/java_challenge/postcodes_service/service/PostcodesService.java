package com.julian.java_challenge.postcodes_service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.julian.java_challenge.postcodes_service.enums.PostcodesError;
import com.julian.java_challenge.postcodes_service.model.Postcode;
import com.julian.java_challenge.postcodes_service.repository.PostcodeRepository;
import com.julian.java_challenge.postcodes_service.utils.DistanceCalculator;

@Service
public class PostcodesService {
    private final PostcodeRepository postcodeRepository;

    public PostcodesService(PostcodeRepository postcodeRepository) {
        this.postcodeRepository = postcodeRepository;
    }

    public Page<Postcode> getPostcodes(int limit, int page) {
        Pageable pageable = PageRequest.of(page - 1, limit);

        try {
            return postcodeRepository.findAll(pageable);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    public String getPostcodesDistanceInKm(String postcode1, String postcode2) {
        try {
            Postcode postcode1Document = postcodeRepository.findByPostcode(postcode1);
            Postcode postcode2Document = postcodeRepository.findByPostcode(postcode2);

            if (postcode1Document == null) {
                throw new RuntimeException(PostcodesError.POST_NOT_FOUND.getName() + "[" + postcode1 + "]");
            }

            if (postcode2Document == null) {
                throw new RuntimeException(PostcodesError.POST_NOT_FOUND.getName() + "[" + postcode2 + "]");
            }

            return DistanceCalculator.calculateDistance(postcode1Document.getLatitude(),
                    postcode1Document.getLongitude(),
                    postcode2Document.getLatitude(),
                    postcode2Document.getLongitude()) + "km";
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
