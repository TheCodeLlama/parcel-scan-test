package com.trephax.parcelscannerv1.service;

import com.trephax.parcelscannerv1.model.Parcel;
import com.trephax.parcelscannerv1.repository.ParcelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelService(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    public Optional<Parcel> getParcelById(UUID id) {
        return parcelRepository.findById(id);
    }

    public Parcel createParcel(Parcel parcel) {
        return parcelRepository.save(parcel);
    }

    public void deleteParcel(UUID id) {
        parcelRepository.deleteById(id);
    }
}
