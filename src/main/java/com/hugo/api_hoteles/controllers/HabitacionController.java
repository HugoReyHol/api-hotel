package com.hugo.api_hoteles.controllers;

import com.hugo.api_hoteles.entities.Habitacion;
import com.hugo.api_hoteles.service.HabitacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitacion")
public class HabitacionController {
    private HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @PutMapping("ocupada/{idHabitacion}")
    public ResponseEntity<?> setOcupada(@PathVariable Long idHabitacion) {
        habitacionService.setOcupada(idHabitacion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/hotel={idHotel}&tamano={tamano}&minPrecio={minPrecio}&maxPrecio={maxPrecio}")
    public ResponseEntity<List<Habitacion>> findAllByHotelAndTamanoAndPrecioBetween(@PathVariable Long idHotel, @PathVariable int tamano, @PathVariable float minPrecio, @PathVariable float maxPrecio) {
        return ResponseEntity.ok(habitacionService.findAllByHotelAndTamanoAndPrecioBetween(idHotel, tamano, minPrecio, maxPrecio));
    }

    @PostMapping("save")
    public ResponseEntity<?> saveHabitacion (@RequestBody Habitacion habitacion) {
        System.out.println(habitacion);
        habitacionService.saveHabitacion(habitacion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{idHabitacion}")
    public ResponseEntity<?> deleteHabitacion (@PathVariable Long idHabitacion) {
        habitacionService.deleteHabitacion(idHabitacion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
