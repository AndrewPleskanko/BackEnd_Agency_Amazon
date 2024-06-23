package com.example.amazonagency.controller;

import com.example.amazonagency.entity.Ad;
import com.example.amazonagency.service.AdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/ads")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AdController {

    private final AdService adService;

    @GetMapping
    public List<Ad> getAds() {
        return adService.getAds();
    }
}
