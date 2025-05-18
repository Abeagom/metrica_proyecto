/*
 * Clase Maestro
 * Representa un maestro con su información de acceso y asignaturas que imparte.
 */
package com.proyectofinal.entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author al_12
 */
public class Maestro {

    private String login;
    private String password;
    private String nombre;
    private List<Asignatura> asignaturas;

    /**
     * Constructor para crear un nuevo objeto Maestro.
     *
     * @param login El nombre de usuario para el login
     * @param password La contraseña para el login
     * @param nombre El nombre
     */
    public Maestro(String login, String password, String nombre) {
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        asignaturas = new ArrayList();
    }

    /**
     * Obtiene el nombre de usuario (login) del maestro
     *
     * @return El nombre de usuario (login) del maestro.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Establece el nombre de usuario (login) del maestro.
     *
     * @param login El nombre de usuario (login) del maestro.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Obtiene la contraseña del maestro.
     *
     * @return La contraseña del maestro.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del maestro.
     *
     * @param password La nueva contraseña del maestro.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el nombre del maestro.
     *
     * @return El nombre del maestro.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del maestro.
     *
     * @param nombre El nuevo nombre del maestro.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de asignaturas que imparte el maestro.
     *
     * @return La lista de asignaturas del maestro.
     */
    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    /**
     * Establece la lista de asignaturas que imparte el maestro.
     *
     * @param asignaturas La lista de asignaturas del maestro.
     */
    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    /**
     * Calcula el código hash del maestro basado en el login.
     *
     * @return El código hash del maestro.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.login);
        return hash;
    }

    /**
     * Compara dos objetos Maestro para verificar si son iguales. Dos maestros
     * se consideran iguales si tienen el mismo login.
     *
     * @param obj El objeto con el que se comparará el maestro.
     * @return true si los objetos son iguales (mismo login), false si no.
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
        final Maestro other = (Maestro) obj;
        return Objects.equals(this.login, other.login);
    }

    /**
     * Devuelve una representación en forma de String del objeto Maestro.
     *
     * @return Un String con el login del maestro.
     */
    @Override
    public String toString() {
        return login;
    }

}
