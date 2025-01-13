package com.hugo.api_hoteles.controllers;

import com.hugo.api_hoteles.entities.Hotel;
import com.hugo.api_hoteles.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/localidad/{localidad}")
    public ResponseEntity<List<Hotel>> findAllByLocalidad(@PathVariable String localidad) {
        return ResponseEntity.ok(hotelService.findAllByLocalidad(localidad));
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Hotel>> findAllByCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(hotelService.findAllByCategoria(categoria));
    }

    @PostMapping("save")
    public ResponseEntity<?> saveHotel(@RequestBody Hotel hotel) {
        hotelService.saveHotel(hotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
