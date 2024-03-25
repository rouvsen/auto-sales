package com.ingress.autosales.service;

import com.ingress.autosales.constants.*;
import com.ingress.autosales.domain.*;
import com.ingress.autosales.dto.AutoDTO;
import com.ingress.autosales.repository.AutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AutoService {

    private final AutoRepository autoRepository;
    private final SellerService sellerService;
    private final AutoDetailsService autoDetailsService;
    private final BrandService brandService;
    private final CityService cityService;
    private final BanTypeService banTypeService;

    @Transactional
    public AutoEntity create(AutoDTO dto, Integer sellerId) {
        SellerEntity sellerEntity = sellerService.findById(sellerId);
        BrandEntity brand = brandService.findById(dto.brandId());
        CityEntity city = cityService.findById(dto.cityId());
        BanTypeEntity banType = banTypeService.findById(dto.banTypeId());
        AutoEntity auto = AutoEntity.builder()
                .seller(sellerEntity)
                .brand(brand)
                .state(State.valueOf(dto.state().toUpperCase()))
                .city(city)
                .price(BigDecimal.valueOf(dto.price()))
                .currency(Currency.valueOf(dto.currency().toUpperCase()))
                .banType(banType)
                .year(dto.year())
                .isAutoDetails(dto.isAutoDetails())
                .build();
        autoRepository.save(auto);
        if (auto.getIsAutoDetails()) {
            autoDetailsService.create(buildDetails(auto, dto));
        }
        return auto;
    }

    private AutoDetailsEntity buildDetails(AutoEntity auto, AutoDTO dto) {
        return AutoDetailsEntity.builder()
                .auto(auto)
                .color(Objects.nonNull(dto.color()) ? Color.valueOf(dto.color().toUpperCase()) : Color.UNKNOWN)
                .fuelType(Objects.nonNull(dto.fuelType()) ? FuelType.valueOf(dto.fuelType().toUpperCase()) : FuelType.UNKNOWN)
                .transmitter(Objects.nonNull(dto.transmitter()) ? Transmitter.valueOf(dto.transmitter().toUpperCase()) : Transmitter.UNKNOWN)
                .gearbox(Objects.nonNull(dto.gearbox()) ? Gearbox.valueOf(dto.gearbox().toUpperCase()) : Gearbox.UNKNOWN)
                .volume(dto.volume())
                .power(dto.power())
                .mileage(dto.mileage())
                .totalOwners(dto.totalOwners())
                .totalSeats(dto.totalSeats())
                .madeFor(Objects.nonNull(dto.madeFor()) ? MadeFor.valueOf(dto.madeFor().toUpperCase()) : MadeFor.UNKNOWN)
                .status(Objects.nonNull(dto.status()) ? Status.valueOf(dto.status().toUpperCase()) : Status.UNKNOWN)
                .credit(dto.credit())
                .barter(dto.barter())
                .punctuation(dto.punctuation())
                .colored(dto.colored())
                .isAccidental(dto.isAccidental())
                .alloyWheels(dto.alloyWheels())
                .abs(dto.abs())
                .hatch(dto.hatch())
                .rainSensor(dto.rainSensor())
                .centralLocking(dto.centralLocking())
                .parkingRadar(dto.parkingRadar())
                .airConditioning(dto.airConditioning())
                .seatHeating(dto.seatHeating())
                .leatherSalon(dto.leatherSalon())
                .xenonLamps(dto.xenonLamps())
                .rearViewCamera(dto.rearViewCamera())
                .sideCurtains(dto.sideCurtains())
                .seatVentilation(dto.seatVentilation())
                .build();
    }

    public void delete(Integer sellerId, String pin) {
        sellerService.findById(sellerId);//check Seller is exists?
        UUID autoUUID = UUID.fromString(pin);
        AutoEntity autoEntity = autoRepository.findByPin(autoUUID).orElseThrow(
                //throw an Exception
        );
        if (!autoEntity.getSeller().getId().equals(sellerId)) {
            //throw an Exception
        }
        autoRepository.deleteById(autoEntity.getId());
    }
}
