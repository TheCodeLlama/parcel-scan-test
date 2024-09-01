package com.trephax.parcelscannerv1.repository;

import com.trephax.parcelscannerv1.model.Parcel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Heath Barcus
 */

public interface ParcelRepository extends JpaRepository<Parcel, UUID> {
}
