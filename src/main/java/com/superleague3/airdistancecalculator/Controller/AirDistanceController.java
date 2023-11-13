package com.superleague3.airdistancecalculator.Controller;

import com.superleague3.airdistancecalculator.Service.Haversine;
import com.superleague3.airdistancecalculator.POJOs.GeocodingAPIResponse;
import com.superleague3.airdistancecalculator.POJOs.Location;
import com.superleague3.airdistancecalculator.POJOs.Result;
import com.superleague3.airdistancecalculator.POJOs.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping
public class AirDistanceController {

    @Value("${geocode_api_key}")
    String apiKey;

    @Autowired
    private Haversine haversine;

    @GetMapping("/getCoords")
    @ResponseBody
    public ResponseEntity<Location> getCoordinates(@RequestParam(name="address") String address){

        Location location = new Location();
        try {
            String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8.toString());
            System.out.println("address encoded = " + encodedAddress);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + encodedAddress + "&key=" + apiKey;
            ResponseEntity<GeocodingAPIResponse> responseEntity = restTemplate.getForEntity(url, GeocodingAPIResponse.class);
            Result result = responseEntity.getBody().getResults().get(0);
            location = result.getGeometry().getLocation();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("Couldn't get coordinates from Geocoding API "
                    + e.getMessage() + "\n" + e.getCause());

        }
        ResponseEntity<Location> responseEntity = ResponseEntity.ok(location);
        return responseEntity;
    }

    @PostMapping("/getDistance")
    public Double getDistance(@RequestBody Coordinates coords) {
        //Haversine haversine = new Haversine();
        Location loc1 = coords.getLoc1();
        Location loc2 = coords.getLoc2();
        return haversine.getDistance(loc1.getLat(), loc1.getLng(), loc2.getLat(), loc2.getLng());
    }
}
