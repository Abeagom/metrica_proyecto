/*
 * Clase Asignatura
 */
package com.proyectofinal.entidades;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author al_12
 */
public class Asignatura {
    private String nombre;
    private List<Tema> temas;
    Maestro maestro;

    public Asignatura(String nombre) {
        this.nombre = nombre;
        temas = new ArrayList();
    }
    
    
}
