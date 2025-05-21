/*
 * Clase Tema
 * Representa un tema en una asignatura, con su información y las actividades relacionadas.
 */
package com.proyectofinal.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author al_12
 */
public class Tema implements Comparable<Tema>{

    private int id;
    private String nombre;
    private List<Actividad> actividades;
    private Asignatura asignatura;

    /**
     * Constructor para crear un nuevo objeto Tema.
     *
     * @param id El identificador único del tema.
     * @param nombre El nombre del tema.
     * @param asignatura La asignatura a la que pertenece el tema.
     */
    public Tema(int id, String nombre, Asignatura asignatura) {
        this.id = id;
        this.nombre = nombre;
        this.asignatura = asignatura;
        actividades = new ArrayList();
    }

    /**
     * Obtiene el id del tema.
     *
     * @return El id del tema.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del tema.
     *
     * @param id El nuevo id del tema.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del tema.
     *
     * @return El nombre del tema.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del tema.
     *
     * @param nombre El nuevo nombre del tema.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de actividades asociadas a este tema.
     *
     * @return La lista de actividades del tema.
     */
    public List<Actividad> getActividades() {
        return actividades;
    }

    /**
     * Establece la lista de actividades asociadas al tema.
     *
     * @param actividades La nueva lista de actividades del tema.
     */
    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    /**
     * Obtiene la asignatura a la que pertenece este tema.
     *
     * @return La asignatura del tema.
     */
    public Asignatura getAsignatura() {
        return asignatura;
    }

    /**
     * Establece la asignatura a la que pertenece este tema.
     *
     * @param asignatura La nueva asignatura del tema.
     */
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    /**
     * Calcula el código hash del tema basado en su id.
     *
     * @return El código hash del tema.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
        return hash;
    }

    /**
     * Compara dos objetos Tema para verificar si son iguales. Dos temas se
     * consideran iguales si tienen el mismo id.
     *
     * @param obj El objeto con el que se comparará el tema.
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
        final Tema other = (Tema) obj;
        return this.id == other.id;
    }

    /**
     * Devuelve una representación en forma de String del objeto Tema.
     *
     * @return Un String con el nombre del tema.
     */
    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Tema t) {
        return this.getNombre().compareTo(t.getNombre());
    }

}
