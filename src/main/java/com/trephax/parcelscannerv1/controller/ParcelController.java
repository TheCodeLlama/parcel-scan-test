package com.trephax.parcelscannerv1.controller;

import com.trephax.parcelscannerv1.model.Parcel;
import com.trephax.parcelscannerv1.service.ParcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/parcels")
@RequiredArgsConstructor
public class ParcelController {

    private final ParcelService parcelService;

    @GetMapping
    public List<Parcel> getAllParcels() {
        return parcelService.getAllParcels();
    }

    @GetMapping("/{id}")
    public Optional<Parcel> getParcelById(@PathVariable UUID id) {
        return parcelService.getParcelById(id);
    }

    @PostMapping
    public Parcel createParcel(@RequestBody Parcel parcel) {
        return parcelService.createParcel(parcel);
    }

    @DeleteMapping("/{id}")
    public void deleteParcel(@PathVariable UUID id) {
        parcelService.deleteParcel(id);
    }
}
