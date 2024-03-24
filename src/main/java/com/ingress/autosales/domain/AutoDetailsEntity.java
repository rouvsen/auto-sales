package com.ingress.autosales.domain;

import com.ingress.autosales.constants.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auto_details")
public class AutoDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_id")
    private AutoEntity auto;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    private Transmitter transmitter;

    @Enumerated(EnumType.STRING)
    private Gearbox gearbox;

    private Integer volume;

    private Integer power;

    private Integer mileage;

    private Short totalOwners;

    private Integer totalSeats;

    private String madeFor;

    @Enumerated(EnumType.STRING)
    private Status status;

    //Bool
    private Boolean credit;
    private Boolean barter;
    private Boolean punctuation;
    private Boolean colored;
    private Boolean isAccidental;
    private Boolean alloyWheels;
    private Boolean abs;
    private Boolean hatch;
    private Boolean rainSensor;
    private Boolean centralLocking;
    private Boolean parkingRadar;
    private Boolean airConditioning;
    private Boolean seatHeating;
    private Boolean leatherSalon;
    private Boolean xenonLamps;
    private Boolean rearViewCamera;
    private Boolean sideCurtains;
    private Boolean seatVentilation;
}
