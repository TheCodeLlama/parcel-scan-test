package com.trephax.parcelscannerv1.service;

import com.trephax.parcelscannerv1.model.Parcel;
import com.trephax.parcelscannerv1.model.Region;
import com.trephax.parcelscannerv1.model.dto.ParcelDTO;
import com.trephax.parcelscannerv1.repository.ParcelRepository;
import com.trephax.parcelscannerv1.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;
    private final RegionRepository regionRepository;

    public ParcelService(ParcelRepository parcelRepository, RegionRepository regionRepository) {
        this.parcelRepository = parcelRepository;
        this.regionRepository = regionRepository;
    }

    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    public Optional<Parcel> getParcelById(UUID id) {
        return parcelRepository.findById(id);
    }

    public Parcel createParcel(ParcelDTO parcelDTO) {
        // Look up the region by name
        Optional<Region> regionOptional = regionRepository.findByName(parcelDTO.getRegionName());

        if (!regionOptional.isPresent()) {
            throw new RuntimeException("Region not found: " + parcelDTO.getRegionName());
        }

        Region region = regionOptional.get();

        // Convert DTO to entity
        Parcel parcel = Parcel.builder()
            .id(UUID.fromString(parcelDTO.getId()))
            .region(region)
            .allowsFly(parcelDTO.isAllowsFly())
            .allowsScripts(parcelDTO.isAllowsScripts())
            .forSale(parcelDTO.isForSale())
            .allowsLandmark(parcelDTO.isAllowsLandmark())
            .allowsTerraform(parcelDTO.isAllowsTerraform())
            .allowsDamage(parcelDTO.isAllowsDamage())
            .allowsCreateObjects(parcelDTO.isAllowsCreateObjects())
            .allowsObjectPurchaseWithLand(parcelDTO.isAllowsObjectPurchaseWithLand())
            .usesAccessGroup(parcelDTO.isUsesAccessGroup())
            .usesAccessList(parcelDTO.isUsesAccessList())
            .usesBanList(parcelDTO.isUsesBanList())
            .usesLandPassList(parcelDTO.isUsesLandPassList())
            .showsDirectory(parcelDTO.isShowsDirectory())
            .allowsDeedToGroup(parcelDTO.isAllowsDeedToGroup())
            .contributesWithDeed(parcelDTO.isContributesWithDeed())
            .localSoundsOnly(parcelDTO.isLocalSoundsOnly())
            .objectsOnLandIncludedInSale(parcelDTO.isObjectsOnLandIncludedInSale())
            .allowPublish(parcelDTO.isAllowPublish())
            .isMaturePublish(parcelDTO.isMaturePublish())
            .urlIsWebPage(parcelDTO.isUrlIsWebPage())
            .urlIsRawHtml(parcelDTO.isUrlIsRawHtml())
            .restrictsPushObject(parcelDTO.isRestrictsPushObject())
            .deniesAnonymous(parcelDTO.isDeniesAnonymous())
            .deniesIdentified(parcelDTO.isDeniesIdentified())
            .deniesTransacted(parcelDTO.isDeniesTransacted())
            .allowsGroupScripts(parcelDTO.isAllowsGroupScripts())
            .allowsCreateGroupObjects(parcelDTO.isAllowsCreateGroupObjects())
            .allowsAllObjectEntry(parcelDTO.isAllowsAllObjectEntry())
            .allowsGroupObjectEntry(parcelDTO.isAllowsGroupObjectEntry())
            .allowsVoiceChat(parcelDTO.isAllowsVoiceChat())
            .usesEstateVoiceChan(parcelDTO.isUsesEstateVoiceChan())
            .deniesAgeUnverified(parcelDTO.isDeniesAgeUnverified())
            .name(parcelDTO.getName())
            .description(parcelDTO.getDescription())
            .owner(parcelDTO.getOwner())
            .group(UUID.fromString(parcelDTO.getGroup()))
            .area(parcelDTO.getArea())
            .seeAvatars(parcelDTO.isSeeAvatars())
            .primCapacity(parcelDTO.getPrimCapacity())
            .primUsed(parcelDTO.getPrimUsed())
            .landingPoint(parcelDTO.getLandingPoint())
            .flags(parcelDTO.getFlags())
            .build();

        // Save the Parcel entity
        return parcelRepository.save(parcel);
    }

    public void deleteParcel(UUID id) {
        parcelRepository.deleteById(id);
    }
}
