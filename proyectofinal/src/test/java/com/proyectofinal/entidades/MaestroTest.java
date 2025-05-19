/*
 * Clase MaestroTest para pruebas unitarias
 */
package com.proyectofinal.entidades;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author al_12
 */
public class MaestroTest {

    Maestro m;
    List<Asignatura> listaAsignaturas;

    @BeforeEach
    public void setUp() throws Exception {
        m = new Maestro("usuPrueba", "passwordPrueba", "prueba");
        listaAsignaturas = new ArrayList<>();
        listaAsignaturas.add(new Asignatura(1, "Lengua", m));
        listaAsignaturas.add(new Asignatura(2, "Matemáticas", m));
    }

    @Test
    @DisplayName("Test del método getLogin")
    public void testGetLogin() {
        String resultadoEsperado = "usuPrueba";
        assertEquals(resultadoEsperado, m.getLogin(), "El nombre de usuario no coincide");
    }

    /**
     * Test of setLogin method, of class Maestro.
     */
    @Test
    @DisplayName("Test del método setLogin")
    public void testSetLogin() {
        String resultadoEsperado = "usuPrueba1";
        m.setLogin("usuPrueba1");
        assertEquals(resultadoEsperado, m.getLogin(), "El nombre de usuario no coincide");
    }

    /**
     * Test of getPassword method, of class Maestro.
     */
    @Test
    @DisplayName("Test del método getPassword")
    public void testGetPassword() {
        String resultadoEsperado = "passwordPrueba";
        assertEquals(resultadoEsperado, m.getPassword(), "Las contraseñas no coinciden");
    }

    /**
     * Test of setPassword method, of class Maestro.
     */
    @Test
    @DisplayName("Test del método setPassword")
    public void testSetPassword() {
        String resultadoEsperado = "passwordPrueba1";
        m.setPassword("passwordPrueba1");
        assertEquals(resultadoEsperado, m.getPassword(), "Las contraseñas no coinciden");
    }

    /**
     * Test of getNombre method, of class Maestro.
     */
    @Test
    @DisplayName("Test del método getNombre")
    public void testGetNombre() {
        String resultadoEsperado = "prueba";
        assertEquals(resultadoEsperado, m.getNombre(), "Los nombres no coinciden");
    }

    /**
     * Test of setNombre method, of class Maestro.
     */
    @Test
    @DisplayName("Test del método getNombre")
    public void testSetNombre() {
        String resultadoEsperado = "prueba1";
        m.setNombre("prueba1");
        assertEquals(resultadoEsperado, m.getNombre(), "Los nombres no coinciden");
    }

    /**
     * Test of getAsignaturas method, of class Maestro.
     */
    @Test
    @DisplayName("Test del método getAsignaturas")
    public void testGetAsignaturas() {
        int resultadoEsperado = 2;
        m.setAsignaturas(listaAsignaturas);
        assertEquals(resultadoEsperado, m.getAsignaturas().size(), "Los tamaños de la lista no coinciden");
    }

    /**
     * Test of setAsignaturas method, of class Maestro.
     */
    @Test
    @DisplayName("Test del método setAsignaturas")
    public void testSetAsignaturas() {
        int resultadoEsperado = 2;
        m.setAsignaturas(listaAsignaturas);
        assertEquals(resultadoEsperado, m.getAsignaturas().size(), "Los tamaños de la lista no coinciden");
    }

    /**
     * Test of hashCode method, of class Maestro.
     */
    @Test
    @DisplayName("Test del método hashCode")
    public void testHashCode() {
        Asignatura a1 = new Asignatura(1, "Lengua", m);
        Asignatura a2 = new Asignatura(1, "Lengua", m);
        assertEquals(a1.hashCode(), a2.hashCode(), "Los hashCodes no coinciden");
    }

    /**
     * Test of equals method, of class Maestro.
     */
    @Test
    @DisplayName("Test del método equals")
    public void testEquals() {
        Maestro m2 = m;
        assertTrue(m2.equals(m), "Los objetos no son iguales");
    }

    /**
     * Test of toString method, of class Maestro.
     */
    @Test
    @DisplayName("Test del método toString")
    public void testToString() {
        String resultadoEsperado = "usuPrueba";
        assertEquals(resultadoEsperado, m.toString(), "La cadena devuelta no coincide");
    }

}
