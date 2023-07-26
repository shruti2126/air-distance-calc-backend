package com.superleague3.airdistancecalculator.POJOs;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Viewport {
    private Location northeast;
    private Location southwest;
}
