package com.hugo.api_hoteles.controllers;

import com.hugo.api_hoteles.entities.Hotel;
import com.hugo.api_hoteles.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@Tag(name = "Hoteles", description = "Lista de hoteles")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/localidad/{localidad}")
    @Operation(summary = "Obtener todos los hoteles en una localidad", description = "Obtiene una lista con todos los hoteles en una localidad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de hoteles obtenida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public ResponseEntity<List<Hotel>> findAllByLocalidad(@PathVariable String localidad) {
        return ResponseEntity.ok(hotelService.findAllByLocalidad(localidad));
    }

    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Obtener todos los hoteles de una categoria", description = "Obtiene una lista con todos los hoteles de una categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de hoteles obtenida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public ResponseEntity<List<Hotel>> findAllByCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(hotelService.findAllByCategoria(categoria));
    }

    @PostMapping("save")
    @Operation(summary = "Guarda un nuevo hotel", description = "Guarda un nuevo hotel en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Hotel guardado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public ResponseEntity<?> saveHotel(@RequestBody Hotel hotel) {
        hotelService.saveHotel(hotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
