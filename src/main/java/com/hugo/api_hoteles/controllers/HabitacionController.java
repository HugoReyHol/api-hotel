package com.hugo.api_hoteles.controllers;

import com.hugo.api_hoteles.entities.Habitacion;
import com.hugo.api_hoteles.service.HabitacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitacion")
@Tag(name = "Habitaciones", description = "Lista de habitaciones")
public class HabitacionController {
    private HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @PutMapping("ocupada/{idHabitacion}")
    @Operation(summary = "Ocupa una habitacion", description = "Cambia el estado ocupada de una habitacion a True")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cambio realizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontro la habitacion")
    })
    public ResponseEntity<?> setOcupada(@PathVariable Long idHabitacion) {
        habitacionService.setOcupada(idHabitacion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/hotel={idHotel}&tamano={tamano}&minPrecio={minPrecio}&maxPrecio={maxPrecio}")
    @Operation(summary = "Busca habitaciones", description = "Obtiene una lista de habitaciones que cumplan los parametros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public ResponseEntity<List<Habitacion>> findAllByHotelAndTamanoAndPrecioBetween(@PathVariable Long idHotel, @PathVariable int tamano, @PathVariable float minPrecio, @PathVariable float maxPrecio) {
        return ResponseEntity.ok(habitacionService.findAllByHotelAndTamanoAndPrecioBetween(idHotel, tamano, minPrecio, maxPrecio));
    }

    @PostMapping("save")
    @Operation(summary = "Guarda una nueva habitacion", description = "Guarda una nueva habitacion en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Habitacion guardada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public ResponseEntity<?> saveHabitacion (@RequestBody Habitacion habitacion) {
        System.out.println(habitacion);
        habitacionService.saveHabitacion(habitacion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{idHabitacion}")
    @Operation(summary = "Eliminar una habitacion por ID", description = "Elimina una habitacion por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Habitacion eliminada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "Habitacion no encontrada")
    })
    public ResponseEntity<?> deleteHabitacion (@PathVariable Long idHabitacion) {
        habitacionService.deleteHabitacion(idHabitacion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
