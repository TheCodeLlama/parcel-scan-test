package com.trephax.parcelscannerv1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
import org.hibernate.proxy.HibernateProxy;

@Entity
@Table(name = "regions")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    private boolean allowsDamage;
    private boolean isFixedSun;
    private boolean blocksTerraform;
    private boolean isSandbox;
    private boolean disablesCollisions;
    private boolean disablesPhysics;
    private boolean blocksFly;
    private boolean allowsDirectTeleport;
    private boolean restrictsPushObject;
    private boolean allowsLandmark;
    private boolean allowsSetHome;
    private boolean resetsHomeOnTeleport;
    private boolean blocksLandResell;
    private boolean hardAllowLandTransfer;
    private boolean skipsUpdateInterestList;
    private boolean skipsScripts;
    private boolean isExternallyVisible;
    private boolean allowsReturnEncroachingObject;
    private boolean allowsReturnEncroachingEstateObject;
    private boolean blocksDwell;
    private boolean estateSkipsScripts;
    private boolean deniesAnonymous;
    private boolean deniesIdentified;
    private boolean deniesTransacted;
    private boolean allowsParcelChanges;
    private boolean abuseEmailGoesToEstateOwner;
    private boolean allowsVoice;
    private boolean blocksParcelSearch;
    private boolean deniesAgeUnverified;
    private boolean skipsMonoScripts;

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
        Region region = (Region) o;
        return getId() != null && Objects.equals(getId(), region.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
            ? ((HibernateProxy) this).getHibernateLazyInitializer()
            .getPersistentClass().hashCode() : getClass().hashCode();
    }
}