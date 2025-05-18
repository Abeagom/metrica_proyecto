/*
 * Clase Actividad
 * Representa una actividad en el sistema, asociada a un tema y con su información detallada.
 */
package com.proyectofinal.entidades;

import java.time.LocalDate;

/**
 *
 * @author al_12
 */
public class Actividad {

    private int id;
    private String nombre;
    private String descripcion;
    private String objetivos;
    private Tema tema;
    LocalDate fecha;

    /**
     * Constructor para crear una nueva actividad.
     *
     * @param id El id de la actividad.
     * @param nombre El nombre de la actividad.
     * @param descripcion La descripción de la actividad.
     * @param objetivos Los objetivos de la actividad.
     * @param tema El tema al que pertenece la actividad.
     * @param fecha La fecha en la que se realiza la actividad.
     */
    public Actividad(int id, String nombre, String descripcion, String objetivos, Tema tema, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objetivos = objetivos;
        this.tema = tema;
        this.fecha = fecha;
    }

    /**
     * Obtiene el id único de la actividad.
     *
     * @return El id de la actividad.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id de la actividad.
     *
     * @param id El nuevo id de la actividad.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la actividad.
     *
     * @return El nombre de la actividad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la actividad.
     *
     * @param nombre El nuevo nombre de la actividad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción de la actividad.
     *
     * @return La descripción de la actividad.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la actividad.
     *
     * @param descripcion La nueva descripción de la actividad.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene los objetivos de la actividad.
     *
     * @return Los objetivos de la actividad.
     */
    public String getObjetivos() {
        return objetivos;
    }

    /**
     * Establece los objetivos de la actividad.
     *
     * @param objetivos Los nuevos objetivos de la actividad.
     */
    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    /**
     * Obtiene el tema al que pertenece la actividad.
     *
     * @return El tema de la actividad.
     */
    public Tema getTema() {
        return tema;
    }

    /**
     * Establece el tema al que pertenece la actividad.
     *
     * @param tema El nuevo tema de la actividad.
     */
    public void setTema(Tema tema) {
        this.tema = tema;
    }

    /**
     * Obtiene la fecha en la que se realiza la actividad.
     *
     * @return La fecha de la actividad.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en la que se realiza la actividad.
     *
     * @param fecha La nueva fecha de la actividad.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Calcula el código hash de la actividad basado en su id.
     *
     * @return El código hash de la actividad.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        return hash;
    }

    /**
     * Compara dos objetos Actividad para verificar si son iguales. Dos
     * actividades se consideran iguales si tienen el mismo id.
     *
     * @param obj El objeto con el que se comparará la actividad.
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
        final Actividad other = (Actividad) obj;
        return this.id == other.id;
    }

    /**
     * Devuelve una representación en forma de String del objeto Actividad.
     *
     * @return Un String con el nombre de la actividad.
     */
    @Override
    public String toString() {
        return nombre;
    }

}
