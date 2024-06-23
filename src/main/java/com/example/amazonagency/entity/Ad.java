package com.example.amazonagency.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ad {
    private Long id;
    private String name;
    private int clicks;
    private int impressions;
}
