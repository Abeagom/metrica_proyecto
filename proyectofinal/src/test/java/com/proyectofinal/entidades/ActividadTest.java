/*
 * Clase ActividadTest para pruebas unitarias
 */
package com.proyectofinal.entidades;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author al_12
 */
public class ActividadTest {

    Maestro m;
    Asignatura a;
    Tema t;
    Actividad ac;

    public ActividadTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        m = new Maestro("usuPrueba", "passwordPrueba", "prueba");
        a = new Asignatura(1, "Matemáticas", m);
        t = new Tema(1, "Números naturales", a);
        ac = new Actividad(1, "Cálculo1", "Operaciones de cálculo", "1", t, LocalDate.of(2025, 5, 19));
    }

    /**
     * Test of getId method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método getId")
    public void testGetId() {
        int resultadoEsperado = 1;
        assertEquals(resultadoEsperado, ac.getId(), "El id no coincide");
    }

    /**
     * Test of setId method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método SetId")
    public void testSetId() {
        int resultadoEsperado = 2;
        ac.setId(2);
        assertEquals(resultadoEsperado, ac.getId(), "El id no coincide");
    }

    /**
     * Test of getNombre method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método getNombre")
    public void testGetNombre() {
        String resultadoEsperado = "Cálculo1";
        assertEquals(resultadoEsperado, ac.getNombre(), "El nombre no coincide");
    }

    /**
     * Test of setNombre method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método setNombre")
    public void testSetNombre() {
        String resultadoEsperado = "Cálculo2";
        ac.setNombre("Cálculo2");
        assertEquals(resultadoEsperado, ac.getNombre(), "El nombre no coincide");
    }

    /**
     * Test of getDescripcion method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método getDescripcion")
    public void testGetDescripcion() {
        String resultadoEsperado = "Operaciones de cálculo";
        assertEquals(resultadoEsperado, ac.getDescripcion(), "La descripción no coincide");
    }

    /**
     * Test of setDescripcion method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método setDescripcion")
    public void testSetDescripcion() {
        String resultadoEsperado = "Operaciones de sumas y restas";
        ac.setDescripcion("Operaciones de sumas y restas");
        assertEquals(resultadoEsperado, ac.getDescripcion(), "La descripción no coincide");
    }

    /**
     * Test of getObjetivos method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método getObjetivos")
    public void testGetObjetivos() {
        String resultadoEsperado = "1";
        assertEquals(resultadoEsperado, ac.getObjetivos(), "Los objetivos no coinciden");
    }

    /**
     * Test of setObjetivos method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método setDescripcion")
    public void testSetObjetivos() {
        String resultadoEsperado = "2";
        ac.setObjetivos("2");
        assertEquals(resultadoEsperado, ac.getObjetivos(), "Los objetivos no coinciden");
    }

    /**
     * Test of getTema method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método getTema")
    public void testGetTema() {
        ac.setTema(t);
        assertEquals(t, ac.getTema(), "Los temas no coinciden");
    }

    /**
     * Test of setTema method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método setTema")
    public void testSetTema() {
        ac.setTema(t);
        assertEquals(t, ac.getTema(), "Los temas no coinciden");
    }

    /**
     * Test of getFecha method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método getFecha")
    public void testGetFecha() {
        LocalDate resultadoEsperado = LocalDate.of(2025, 5, 19);
        assertEquals(resultadoEsperado, ac.getFecha(), "Las fechas no coinciden");
    }

    /**
     * Test of setFecha method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método setFecha")
    public void testSetFecha() {
        LocalDate resultadoEsperado = LocalDate.of(2025, 5, 20);
        ac.setFecha(LocalDate.of(2025, 5, 20));
        assertEquals(resultadoEsperado, ac.getFecha(), "Las fechas no coinciden");
    }

    /**
     * Test of hashCode method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método hashCode")
    public void testHashCode() {
        Actividad ac1 = new Actividad(2, "Cálculo2", "Operaciones de cálculo2", "1", t, null);
        Actividad ac2 = new Actividad(2, "Cálculo2", "Operaciones de cálculo2", "1", t, null);
        assertEquals(ac1.hashCode(), ac2.hashCode(), "Los hashCodes no coinciden");
    }

    /**
     * Test of equals method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método equals")
    public void testEquals() {
        Actividad ac2 = ac;
        assertTrue(ac2.equals(ac), "Los objetos no son iguales");
    }

    /**
     * Test of toString method, of class Actividad.
     */
    @Test
    @DisplayName("Test del método toString")
    public void testToString() {
        String resultadoEsperado = "Cálculo1";
        assertEquals(resultadoEsperado, ac.toString(), "La cadena devuelta no coincide");
    }

}
