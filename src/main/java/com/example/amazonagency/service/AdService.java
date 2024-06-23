package com.example.amazonagency.service;

import com.example.amazonagency.entity.Ad;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Service class for managing ads.
 * <p>
 * This class provides methods to manipulate and retrieve ad data.
 */
@Slf4j
@Service
public class AdService {

    /**
     * Retrieves a list of ads.
     * <p>
     * This method returns a static list of ads for demonstration purposes.
     *
     * @return a list of {@link Ad} objects
     */
    public List<Ad> getAds() {
        return Arrays.asList(
                new Ad(1L, "Ad 1", 100, 1000),
                new Ad(2L, "Ad 2", 150, 1200),
                new Ad(3L, "Ad 3", 200, 1300),
                new Ad(4L, "Ad 4", 250, 1400),
                new Ad(5L, "Ad 5", 300, 1500)
        );
    }
}