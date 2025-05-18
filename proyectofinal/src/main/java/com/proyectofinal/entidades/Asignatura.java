/*
 * Clase Asignatura
 * Representa una asignatura en el sistema, con su información básica y los temas asociados.
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

    /**
     * Constructor para crear una nueva asignatura.
     *
     * @param id El id de la asignatura.
     * @param nombre El nombre de la asignatura.
     * @param maestro El maestro que imparte la asignatura.
     */
    public Asignatura(int id, String nombre, Maestro maestro) {
        this.id = id;
        this.nombre = nombre;
        this.maestro = maestro;
        temas = new ArrayList();
    }

    /**
     * Obtiene el id de la asignatura.
     *
     * @return El id de la asignatura.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id de la asignatura.
     *
     * @param id El nuevo id de la asignatura.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la asignatura.
     *
     * @return El nombre de la asignatura.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la asignatura.
     *
     * @param nombre El nuevo nombre de la asignatura.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de temas asociados a esta asignatura.
     *
     * @return La lista de temas de la asignatura.
     */
    public List<Tema> getTemas() {
        return temas;
    }

    /**
     * Establece la lista de temas asociados a esta asignatura.
     *
     * @param temas La nueva lista de temas de la asignatura.
     */
    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    /**
     * Obtiene el maestro que imparte esta asignatura.
     *
     * @return El maestro de la asignatura.
     */
    public Maestro getMaestro() {
        return maestro;
    }

    /**
     * Establece el maestro que imparte esta asignatura.
     *
     * @param maestro El nuevo maestro que imparte la asignatura.
     */
    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    /**
     * Calcula el código hash de la asignatura basado en su id.
     *
     * @return El código hash de la asignatura.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        return hash;
    }

    /**
     * Compara dos objetos Asignatura para verificar si son iguales. Dos
     * asignaturas se consideran iguales si tienen el mismo id.
     *
     * @param obj El objeto con el que se comparará la asignatura.
     * @return true si los objetos son iguales (mismo id), false si no.
     */
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

    /**
     * Devuelve una representación en forma de String del objeto Asignatura.
     *
     * @return Un String con el nombre de la asignatura.
     */
    @Override
    public String toString() {
        return nombre;
    }

}
