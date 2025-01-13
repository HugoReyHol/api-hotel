package com.hugo.api_hoteles.repositories;

import com.hugo.api_hoteles.entities.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

    @Query("SELECT h FROM Habitacion h WHERE " +
            "h.hotel.idHotel = :idHotel AND " +
            "h.tamano = :tamano AND " +
            "h.ocupada = FALSE " +
            "AND h.precio BETWEEN :minPrecio AND :maxPrecio")
    List<Habitacion> findAllByHotelAndTamanoAndPrecioBetween(Long idHotel, int tamano, float minPrecio, float maxPrecio);

}
