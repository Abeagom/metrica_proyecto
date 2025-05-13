/*
 * Clase Tema
 */
package com.proyectofinal.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author al_12
 */
public class Tema {
    private String nombre;
    private List<Actividad> actividades;
    private Asignatura asignatura;

    public Tema(String nombre, Asignatura asignatura) {
        this.nombre = nombre;
        this.asignatura = asignatura;
        actividades = new ArrayList();
    }
    
    
}
