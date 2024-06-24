package com.example.amazonagency.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.amazonagency.entity.Ad;
import com.example.amazonagency.exception.InvalidSortOrOrderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
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

    @Test
    public void getSortedAdsWithInvalidSortTest() {
        assertThrows(InvalidSortOrOrderException.class, () -> adService.getSortedAds("", "desc"));
    }

    @Test
    public void getSortedAdsWithInvalidOrderTest() {
        assertThrows(InvalidSortOrOrderException.class, () -> adService.getSortedAds("clicks", ""));
    }

    @Test
    public void getSortedAdsTest() {
        List<Ad> sortedAds = adService.getSortedAds("clicks", "desc");

        assertEquals(5, sortedAds.size(), "Expected 5 ads");

        Ad firstAd = sortedAds.get(0);
        assertEquals(5L, firstAd.getId());
        assertEquals("Ad 5", firstAd.getName());
        assertEquals(300, firstAd.getClicks());
        assertEquals(900, firstAd.getImpressions());
    }
}