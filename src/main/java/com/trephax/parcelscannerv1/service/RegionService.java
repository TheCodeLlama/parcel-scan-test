package com.trephax.parcelscannerv1.service;

import com.trephax.parcelscannerv1.model.Region;
import com.trephax.parcelscannerv1.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Optional<Region> getRegionById(UUID id) {
        return regionRepository.findById(id);
    }

    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }

    public void deleteRegion(UUID id) {
        regionRepository.deleteById(id);
    }
}
