package com.superleague3.airdistancecalculator.POJOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Result {

    private Long id;
    private List<AddressComponent> addressComponents;
    private String formatted_address;
    private Geometry geometry;
    private String place_id;
    private List<String> types;

}
