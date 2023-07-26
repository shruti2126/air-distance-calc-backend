package com.superleague3.airdistancecalculator.POJOs;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressComponent {
    private String long_name;
    private String short_name;
    private List<String> types;
}
