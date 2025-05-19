/*
 * Clase TemaTest para pruebas unitarias
 */
package com.proyectofinal.entidades;

import java.time.LocalDate;
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
public class TemaTest {

    Maestro m;
    Asignatura a;
    Tema t;
    List<Actividad> listaActividades;

    public TemaTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        m = new Maestro("usuPrueba", "passwordPrueba", "prueba");
        a = new Asignatura(1, "Matemáticas", m);
        t = new Tema(1, "Números naturales", a);
        listaActividades = new ArrayList<>();
        listaActividades.add(new Actividad(1, "Cálculo1", "Operaciones de cálculo", "1", t, null));
        listaActividades.add(new Actividad(2, "Cálculo2", "Operaciones de cálculo2", "1", t, null));
    }

    /**
     * Test of getId method, of class Tema.
     */
    @Test
    @DisplayName("Test del método getId")
    public void testGetId() {
        int resultadoEsperado = 1;
        assertEquals(resultadoEsperado, t.getId(), "El id no coincide");
    }

    /**
     * Test of setId method, of class Tema.
     */
    @Test
    @DisplayName("Test del método SetId")
    public void testSetId() {
        int resultadoEsperado = 2;
        t.setId(2);
        assertEquals(resultadoEsperado, t.getId(), "El id no coincide");
    }

    /**
     * Test of getNombre method, of class Tema.
     */
    @Test
    @DisplayName("Test del método getNombre")
    public void testGetNombre() {
        String resultadoEsperado = "Números naturales";
        assertEquals(resultadoEsperado, t.getNombre(), "El nombre no coincide");
    }

    /**
     * Test of setNombre method, of class Tema.
     */
    @Test
    @DisplayName("Test del método setNombre")
    public void testSetNombre() {
        String resultadoEsperado = "Números enteros";
        t.setNombre("Números enteros");
        assertEquals(resultadoEsperado, t.getNombre(), "El nombre no coincide");
    }

    /**
     * Test of getActividades method, of class Tema.
     */
    @Test
    @DisplayName("Test del método getActividades")
    public void testGetActividades() {
        int resultadoEsperado = 2;
        t.setActividades(listaActividades);
        assertEquals(resultadoEsperado, t.getActividades().size(), "Los tamaños de la lista no coinciden");
    }

    /**
     * Test of setActividades method, of class Tema.
     */
    @Test
    @DisplayName("Test del método setActividades")
    public void testSetActividades() {
        int resultadoEsperado = 2;
        t.setActividades(listaActividades);
        assertEquals(resultadoEsperado, t.getActividades().size(), "Los tamaños de la lista no coinciden");
    }

    /**
     * Test of getAsignatura method, of class Tema.
     */
    @Test
    @DisplayName("Test del método getAsignatura")
    public void testGetAsignatura() {
        t.setAsignatura(a);
        assertEquals(a, t.getAsignatura(), "Las asignaturas no coinciden");
    }

    /**
     * Test of setAsignatura method, of class Tema.
     */
    @Test
    @DisplayName("Test del método setAsignatura")
    public void testSetAsignatura() {
        t.setAsignatura(a);
        assertEquals(a, t.getAsignatura(), "Las asignaturas no coinciden");
    }

    /**
     * Test of hashCode method, of class Tema.
     */
    @Test
    @DisplayName("Test del método hashCode")
    public void testHashCode() {
        Tema t1 = new Tema(2, "Números naturales", a);
        Tema t2 = new Tema(2, "Números naturales", a);
        assertEquals(t1.hashCode(), t2.hashCode(), "Los hashCodes no coinciden");
    }

    /**
     * Test of equals method, of class Tema.
     */
    @Test
    @DisplayName("Test del método equals")
    public void testEquals() {
        Tema t2 = t;
        assertTrue(t2.equals(t), "Los objetos no son iguales");
    }

    /**
     * Test of toString method, of class Tema.
     */
    @Test
    @DisplayName("Test del método toString")
    public void testToString() {
        String resultadoEsperado = "Números naturales";
        assertEquals(resultadoEsperado, t.toString(), "La cadena devuelta no coincide");
    }

}
