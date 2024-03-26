package com.ingress.autosales.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ingress.autosales.constants.Currency;
import com.ingress.autosales.constants.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "autos")
public class AutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "pin", updatable = false, nullable = false, unique = true)
    private UUID pin;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private SellerEntity seller;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "ban_type_id")
    private BanTypeEntity banType;

    private Integer year;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Boolean isAutoDetails;

    @OneToMany(mappedBy = "auto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AutoDetailsEntity> autoDetails;

    @PrePersist
    private void generatePin() {
        this.pin = UUID.randomUUID();
    }
}

