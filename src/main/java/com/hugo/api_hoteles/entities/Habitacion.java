package com.hugo.api_hoteles.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long idHabitacion;

    private int tamano;

    private float precio;

    private boolean desayuno;

    private boolean ocupada;

    @ManyToOne
    @JoinColumn(name = "idHotel", referencedColumnName = "id_hotel")
    @JsonBackReference
    private Hotel hotel;

    public Habitacion() {
    }

    public Habitacion(int tamano, float precio, boolean desayuno, boolean ocupada) {
        this.tamano = tamano;
        this.precio = precio;
        this.desayuno = desayuno;
        this.ocupada = ocupada;
    }

    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + idHabitacion +
                ", tamano=" + tamano +
                ", precio=" + precio +
                ", desayuno=" + desayuno +
                ", ocupada=" + ocupada +
                ", hotel=" + hotel +
                '}';
    }
}
