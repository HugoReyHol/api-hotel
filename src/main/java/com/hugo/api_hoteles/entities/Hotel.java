package com.hugo.api_hoteles.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "hoteles")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Long idHotel;

    private String nombre;

    private String descripcion;

    private String categoria;

    private boolean piscina;

    private String localidad;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Habitacion> habitaciones;

    public Hotel() {
    }

    public Hotel(String nombre, String descripcion, String categoria, boolean piscina, String localidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.piscina = piscina;
        this.localidad = localidad;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public void addHabitacion(Habitacion habitacion) {
        this.habitaciones.add(habitacion);
    }

    public void removeHabitacion(Habitacion habitacion) {
        this.habitaciones.remove(habitacion);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + idHotel +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", piscina=" + piscina +
                ", localidad='" + localidad + '\'' +
                ", habitaciones=" + habitaciones +
                '}';
    }
}
