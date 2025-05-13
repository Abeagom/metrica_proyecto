/*
 * Clase Maestro
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

    public Maestro(String login, String password, String nombre) {
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        asignaturas = new ArrayList();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.login);
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
        final Maestro other = (Maestro) obj;
        return Objects.equals(this.login, other.login);
    }
    
    
    
    
}
