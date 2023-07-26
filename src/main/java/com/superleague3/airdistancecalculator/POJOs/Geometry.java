package com.superleague3.airdistancecalculator.POJOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Geometry {

    private Bounds bounds;

    private Location location;
    private String location_type;

    private Viewport viewport;
}
