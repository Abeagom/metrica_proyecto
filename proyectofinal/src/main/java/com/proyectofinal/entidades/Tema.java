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
    private int id;
    private String nombre;
    private List<Actividad> actividades;
    private Asignatura asignatura;

    public Tema(int id, String nombre, Asignatura asignatura) {
        this.id=id;
        this.nombre = nombre;
        this.asignatura = asignatura;
        actividades = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tema other = (Tema) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
    
    
    
}
