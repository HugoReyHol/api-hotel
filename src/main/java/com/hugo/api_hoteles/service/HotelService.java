package com.hugo.api_hoteles.service;

import com.hugo.api_hoteles.entities.Habitacion;
import com.hugo.api_hoteles.entities.Hotel;
import com.hugo.api_hoteles.repositories.HotelRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> findAllByLocalidad(String localidad){
        return hotelRepository.findAllByLocalidad(localidad);
    }

    public List<Hotel> findAllByCategoria(String categoria){
        return hotelRepository.findAllByCategoria(categoria);
    }

    public Hotel saveHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public Hotel addHabitacion(long idHotel, Habitacion habitacion){
        var hotel = hotelRepository.findById(idHotel);

        if (hotel.isPresent()) {
            Hotel foundHotel = hotel.get();
            foundHotel.addHabitacion(habitacion);
            return hotelRepository.save(foundHotel);

        }

        return null;
    }

    public Hotel removeHabitacion(long idHotel, Habitacion habitacion){
        var hotel = hotelRepository.findById(idHotel);

        if (hotel.isPresent()) {
            Hotel foundHotel = hotel.get();
            foundHotel.removeHabitacion(habitacion);
            return hotelRepository.save(foundHotel);

        }

        return null;
    }
}
