package com.julian.java_challenge.postcodes_service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.julian.java_challenge.postcodes_service.model.Postcode;
import com.julian.java_challenge.postcodes_service.repository.PostcodeRepository;

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

}
