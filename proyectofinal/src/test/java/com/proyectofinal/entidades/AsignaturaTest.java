/*
 * Clase AsignaturaTest para pruebas unitarias
 */
package com.proyectofinal.entidades;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author al_12
 */
public class AsignaturaTest {

    Maestro m;
    Asignatura a;
    List<Tema> listaTemas;

    public AsignaturaTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        m = new Maestro("usuPrueba", "passwordPrueba", "prueba");
        a = new Asignatura(1, "Matemáticas", m);
        listaTemas = new ArrayList<>();
        listaTemas.add(new Tema(1, "Números naturales", a));
        listaTemas.add(new Tema(2, "Números enteros", a));
    }

    /**
     * Test of getId method, of class Asignatura.
     */
    @Test
    @DisplayName("Test del método getId")
    public void testGetId() {
        int resultadoEsperado = 1;
        assertEquals(resultadoEsperado, a.getId(), "El id no coincide");
    }

    /**
     * Test of setId method, of class Asignatura.
     */
    @Test
    @DisplayName("Test del método SetId")
    public void testSetId() {
        int resultadoEsperado = 2;
        a.setId(2);
        assertEquals(resultadoEsperado, a.getId(), "El id no coincide");
    }

    /**
     * Test of getNombre method, of class Asignatura.
     */
    @Test
    @DisplayName("Test del método getNombre")
    public void testGetNombre() {
        String resultadoEsperado = "Matemáticas";
        assertEquals(resultadoEsperado, a.getNombre(), "El nombre no coincide");
    }

    /**
     * Test of setNombre method, of class Asignatura.
     */
    @Test
    @DisplayName("Test del método setNombre")
    public void testSetNombre() {
        String resultadoEsperado = "Lengua";
        a.setNombre("Lengua");
        assertEquals(resultadoEsperado, a.getNombre(), "El nombre no coincide");
    }

    /**
     * Test of getTemas method, of class Asignatura.
     */
    @Test
    @DisplayName("Test del método getTemas")
    public void testGetTemas() {
        int resultadoEsperado = 2;
        a.setTemas(listaTemas);
        assertEquals(resultadoEsperado, a.getTemas().size(), "Los tamaños de la lista no coinciden");
    }

    /**
     * Test of setTemas method, of class Asignatura.
     */
    @Test
    @DisplayName("Test del método setTemas")
    public void testSetTemas() {
        int resultadoEsperado = 2;
        a.setTemas(listaTemas);
        assertEquals(resultadoEsperado, a.getTemas().size(), "Los tamaños de la lista no coinciden");
    }

    /**
     * Test of getMaestro method, of class Asignatura.
     */
    @Test
    @DisplayName("Test del método getMaestro")
    public void testGetMaestro() {
        a.setMaestro(m);
        assertEquals(m, a.getMaestro(), "Los maestros no coinciden");
    }

    /**
     * Test of setMaestro method, of class Asignatura.
     */
    @Test
    @DisplayName("Test del método setMaestro")
    public void testSetMaestro() {
        a.setMaestro(m);
        assertEquals(m, a.getMaestro(), "Los maestros no coinciden");
    }

    /**
     * Test of hashCode method, of class Asignatura.
     */
    @Test
    @DisplayName("Test del método hashCode")
    public void testHashCode() {
        Asignatura a1 = new Asignatura(1, "Lengua", m);
        Asignatura a2 = new Asignatura(1, "Lengua", m);
        assertEquals(a1.hashCode(), a2.hashCode(), "Los hashCodes no coinciden");
    }

    /**
     * Test of equals method, of class Asignatura.
     */
    @Test
    @DisplayName("Test del método equals")
    public void testEquals() {
        Asignatura a2 = a;
        assertTrue(a2.equals(a), "Los objetos no son iguales");
    }

    /**
     * Test of toString method, of class Asignatura.
     */
    @Test
    @DisplayName("Test del método toString")
    public void testToString() {
        String resultadoEsperado = "Matemáticas";
        assertEquals(resultadoEsperado, a.toString(), "La cadena devuelta no coincide");
    }

}
