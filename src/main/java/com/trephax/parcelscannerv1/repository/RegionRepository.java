package com.trephax.parcelscannerv1.repository;

import com.trephax.parcelscannerv1.model.Region;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Heath Barcus
 */

public interface RegionRepository extends JpaRepository<Region, UUID> {
    Optional<Region> findByName(String name);
}
