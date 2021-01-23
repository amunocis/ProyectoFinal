package com.example.proyectofinal;

public class Apartment {
    private String nombre;
    private String torre;
    private String depto;
    private String direccion;
    private String urlImage;

    public Apartment(String nombre, String torre, String depto, String direccion, String urlImage) {
        this.nombre = nombre;
        this.torre = torre;
        this.depto = depto;
        this.direccion = direccion;
        this.urlImage = urlImage;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTorre() {
        return torre;
    }

    public String getDepto() {
        return depto;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getUrlImage() {
        return urlImage;
    }
}
