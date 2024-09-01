package com.trephax.parcelscannerv1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.proxy.HibernateProxy;

@Entity
@Table(name = "parcels")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parcel {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @JsonBackReference
    @Exclude
    private Region region;

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
    @Column(name = "parcel_group")
    private String group;
    private int area;
    private boolean seeAvatars;
    private int primCapacity;
    private int primUsed;
    private String landingPoint;
    private int flags;

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Class<?> oEffectiveClass = o instanceof HibernateProxy
            ? ((HibernateProxy) o).getHibernateLazyInitializer()
            .getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
            ? ((HibernateProxy) this).getHibernateLazyInitializer()
            .getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) {
            return false;
        }
        Parcel parcel = (Parcel) o;
        return getId() != null && Objects.equals(getId(), parcel.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
            ? ((HibernateProxy) this).getHibernateLazyInitializer()
            .getPersistentClass().hashCode() : getClass().hashCode();
    }
}
