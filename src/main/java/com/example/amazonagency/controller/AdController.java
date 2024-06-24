package com.example.amazonagency.controller;

import com.example.amazonagency.entity.Ad;
import com.example.amazonagency.service.AdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.ApiOperation;


@Slf4j
@RestController
@RequestMapping("/api/v1/ads")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AdController {

    private final AdService adService;

    @ApiOperation(value = "Get all ads")
    @GetMapping
    public List<Ad> getAds() {
        log.info("Received request to fetch all ads");
        return adService.getAds();
    }

    @ApiOperation(value = "Get sorted ads")
    @GetMapping("/sortedAds")
    public List<Ad> getSortedAds(@RequestParam String sort, @RequestParam String order) {
        log.info("Received request to fetch sorted ads with sort: {} and order: {}", sort, order);
        return adService.getSortedAds(sort, order);
    }
}
