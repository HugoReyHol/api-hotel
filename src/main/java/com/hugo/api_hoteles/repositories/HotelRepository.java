package com.hugo.api_hoteles.repositories;

import com.hugo.api_hoteles.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findAllByLocalidad(String localidad);
    List<Hotel> findAllByCategoria(String categoria);

}
