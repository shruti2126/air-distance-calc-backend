package com.superleague3.airdistancecalculator.POJOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeocodingAPIResponse {

    private Long id;
    private List<Result> results;
    private String status;
}
