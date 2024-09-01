package com.trephax.parcelscannerv1.controller;

import com.trephax.parcelscannerv1.model.Region;
import com.trephax.parcelscannerv1.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }

    @GetMapping("/{id}")
    public Optional<Region> getRegionById(@PathVariable UUID id) {
        return regionService.getRegionById(id);
    }

    @PostMapping
    public Region createRegion(@RequestBody Region region) {
        return regionService.createRegion(region);
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable UUID id) {
        regionService.deleteRegion(id);
    }
}
