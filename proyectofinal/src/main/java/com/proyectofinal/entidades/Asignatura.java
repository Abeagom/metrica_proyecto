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
    private int id;
    private String nombre;
    private List<Tema> temas;
    Maestro maestro;

    public Asignatura(int id, String nombre, Maestro maestro) {
        this.id=id;
        this.nombre = nombre;
        this.maestro=maestro;
        temas = new ArrayList();
    }

    public Asignatura(String nombre, Maestro maestro) {
        this.nombre=nombre;
        this.maestro=maestro;
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

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
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
        final Asignatura other = (Asignatura) obj;
        return this.id == other.id;
    }
    
    
    
    
}
