package com.hugo.api_hoteles.service;

import com.hugo.api_hoteles.entities.Habitacion;
import com.hugo.api_hoteles.repositories.HabitacionRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class HabitacionService {

    private HabitacionRepository habitacionRepository;

    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public Habitacion setOcupada(Long idHabitacion) {
        var habitacion = habitacionRepository.findById(idHabitacion);

        if (habitacion.isPresent()) {
            Habitacion foundHab = habitacion.get();
            foundHab.setOcupada(true);
            return habitacionRepository.save(foundHab);

        }

        return null;
    }

    public List<Habitacion> findAllByHotelAndTamanoAndPrecioBetween(Long idHotel, int tamano, float minPrecio, float maxPrecio){
        return habitacionRepository.findAllByHotelAndTamanoAndPrecioBetween(idHotel, tamano, minPrecio, maxPrecio);
    }

    public Habitacion saveHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public void deleteHabitacion(Long idHabitacion) {
        habitacionRepository.deleteById(idHabitacion);
    }
}
