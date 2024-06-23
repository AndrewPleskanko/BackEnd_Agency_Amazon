package com.example.amazonagency.service;

import com.example.amazonagency.entity.Ad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdServiceTest {

    private AdService adService;

    @BeforeEach
    public void init() {
        adService = new AdService();
    }

    @Test
    public void getAdsTest() {
        List<Ad> ads = adService.getAds();

        assertEquals(5, ads.size(), "Expected 5 ads");

        Ad firstAd = ads.get(0);
        assertEquals(1L, firstAd.getId());
        assertEquals("Ad 1", firstAd.getName());
        assertEquals(100, firstAd.getClicks());
        assertEquals(1000, firstAd.getImpressions());
    }
}