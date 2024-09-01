package com.trephax.parcelscannerv1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParcelDTO {

    private String id;
    private String regionName;
    private boolean allowsFly;
    private boolean allowsScripts;
    private boolean forSale;
    private boolean allowsLandmark;
    private boolean allowsTerraform;
    private boolean allowsDamage;
    private boolean allowsCreateObjects;
    private boolean allowsObjectPurchaseWithLand;
    private boolean usesAccessGroup;
    private boolean usesAccessList;
    private boolean usesBanList;
    private boolean usesLandPassList;
    private boolean showsDirectory;
    private boolean allowsDeedToGroup;
    private boolean contributesWithDeed;
    private boolean localSoundsOnly;
    private boolean objectsOnLandIncludedInSale;
    private boolean allowPublish;
    private boolean isMaturePublish;
    private boolean urlIsWebPage;
    private boolean urlIsRawHtml;
    private boolean restrictsPushObject;
    private boolean deniesAnonymous;
    private boolean deniesIdentified;
    private boolean deniesTransacted;
    private boolean allowsGroupScripts;
    private boolean allowsCreateGroupObjects;
    private boolean allowsAllObjectEntry;
    private boolean allowsGroupObjectEntry;
    private boolean allowsVoiceChat;
    private boolean usesEstateVoiceChan;
    private boolean deniesAgeUnverified;
    private String name;
    private String description;
    private String owner;
    private String group;
    private int area;
    private boolean seeAvatars;
    private int primCapacity;
    private int primUsed;
    private String landingPoint;
    private int flags;
}
