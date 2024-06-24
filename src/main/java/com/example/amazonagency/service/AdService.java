package com.example.amazonagency.service;

import com.example.amazonagency.entity.Ad;
import com.example.amazonagency.exception.InvalidSortOrOrderException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing ads.
 * <p>
 * This class provides methods to manipulate and retrieve ad data.
 */
@Slf4j
@Service
public class AdService {

    private final List<Ad> ads = Arrays.asList(
            new Ad(1L, "Ad 1", 100, 1000),
            new Ad(2L, "Ad 2", 150, 1200),
            new Ad(3L, "Ad 3", 200, 1300),
            new Ad(4L, "Ad 4", 250, 1400),
            new Ad(5L, "Ad 5", 300, 900)
    );

    /**
     * Retrieves a list of ads.
     * <p>
     * This method returns a static list of ads for demonstration purposes.
     *
     * @return a list of {@link Ad} objects
     */
    public List<Ad> getAds() {
        log.info("Fetching all ads");
        return ads;
    }

    /**
     * Retrieves a list of ads sorted by a specific field and order.
     * <p>
     * This method returns a list of ads sorted by the specified field and order.
     * The sort field can be "name", "clicks", or "impressions". The order can be "asc" or "desc".
     *
     * @param sort  the field to sort by
     * @param order the sort order
     * @return a list of {@link Ad} objects sorted by the specified field and order
     * @throws IllegalArgumentException if an invalid sort field is provided
     */
    public List<Ad> getSortedAds(String sort, String order) {
        log.info("Sorting ads by {} in {} order", sort, order);

        if (sort == null || sort.isEmpty() || order == null || order.isEmpty()) {
            log.error("Invalid sort field or order: sort = {}, order = {}", sort, order);
            throw new InvalidSortOrOrderException("Sort field and order must not be null or empty");
        }

        Comparator<Ad> comparator = switch (sort) {
            case "name" -> Comparator.comparing(Ad::getName);
            case "clicks" -> Comparator.comparingInt(Ad::getClicks);
            case "impressions" -> Comparator.comparingInt(Ad::getImpressions);
            default -> throw new IllegalArgumentException("Invalid sort field: " + sort);
        };

        if ("desc".equals(order)) {
            comparator = comparator.reversed();
        }
        log.debug("Return sorted ads");

        return ads.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}