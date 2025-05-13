/*
 * Clase Actividad
 */
package com.proyectofinal.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author al_12
 */
public class Actividad {
    private String nombre;
    private String descripcion;
    private List<String> objetivos;
    private Tema tema;

    public Actividad(String nombre, String descripcion, Tema tema) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tema = tema;
        objetivos = new ArrayList();
    }
    
    
}
