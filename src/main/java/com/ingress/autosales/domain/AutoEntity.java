package com.ingress.autosales.domain;

import com.ingress.autosales.constants.Currency;
import com.ingress.autosales.constants.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "ban_type_id")
    private BanTypeEntity banType;

    private Integer year;

    @OneToMany(mappedBy = "auto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AutoDetailsEntity> autoDetailEntities;
}

