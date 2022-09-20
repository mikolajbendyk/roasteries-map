package com.bendyk.roasteriesmap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "roasteries")
public class Roastery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @NotNull
    private String address;
    @NotNull
    private String webPageUrl;
    private Boolean hasEcommerce;
    private Double freeShipmentFrom;
    private Double googleRating;
    private Integer numberOfGoogleReviews;
    @NotNull
    private IsSpecialty isSpecialty;
}
