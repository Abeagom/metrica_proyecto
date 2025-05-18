/*
 * DAOActividades
 * Operaciones de acceso a datos para la entidad Actividad
 */
package com.proyectofinal.datos;

import com.mysql.cj.jdbc.Driver;
import com.proyectofinal.entidades.Actividad;
import com.proyectofinal.entidades.Tema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author al_12
 */
public class DAOActividades {

    /**
     * Establece una conexión con la base de datos.
     *
     * @return La conexión a la base de datos.
     * @throws SQLException Si ocurre un error al conectar a la base de datos.
     */
    public Connection conectarBD() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/educaplus",
                "educa", "educa");
        return conn;
    }

    /**
     * Cierra la conexión con la base de datos.
     *
     * @param conn La conexión a la base de datos a cerrar.
     */
    public void desconectarBD(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error al desconectar BD DAOActividades: " + e.getMessage());
        }
    }

    /**
     * Obtiene todas las actividades asociadas a un tema.
     *
     * @param t El tema del cual se obtendrán las actividades.
     * @return Una lista de actividades asociadas al tema.
     */
    public List<Actividad> getActividadesPorTema(Tema t) {
        Connection conn = null;
        List<Actividad> actividades = new ArrayList();
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "select * from actividades WHERE id_tema = ?");
            pst.setInt(1, t.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Actividad a = new Actividad(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("objetivos"), t, (rs.getDate("fechaActividad") != null) ? rs.getDate("fechaActividad").toLocalDate() : null);
                actividades.add(a);
            }
        } catch (SQLException e) {
            System.err.println("getActividadesPorTema:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }

        return actividades;
    }

    /**
     * Añade una nueva actividad asociada a un tema.
     *
     * @param nombre El nombre de la actividad.
     * @param descripcion La descripción de la actividad.
     * @param objetivos Los objetivos de la actividad.
     * @param t El tema al cual se asociará la actividad.
     */
    public void añadirActividad(String nombre, String descripcion, String objetivos, Tema t) {
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "Insert into actividades(nombre, descripcion, objetivos, id_tema) values(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, nombre);
            pst.setString(2, descripcion);
            pst.setString(3, objetivos);
            pst.setInt(4, t.getId());
            pst.executeUpdate();
            ResultSet claveGenerada = pst.getGeneratedKeys();
            if (claveGenerada.next()) {
                t.getActividades().add(new Actividad(claveGenerada.getInt(1), nombre, descripcion, objetivos, t, null));
            }

        } catch (SQLException e) {
            System.err.println("añadirActividad:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }

    /**
     * Edita el nombre, descripción y objetivos de una actividad existente.
     *
     * @param nuevoNombre El nuevo nombre de la actividad.
     * @param nuevaDescripcion La nueva descripción de la actividad.
     * @param nuevosObjetivos Los nuevos objetivos de la actividad.
     * @param idActividad El id de la actividad que se editará.
     */
    public void editarActividad(String nuevoNombre, String nuevaDescripcion, String nuevosObjetivos, int idActividad) {
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "UPDATE actividades SET nombre = ?, descripcion = ?, objetivos = ? WHERE id = ?");
            pst.setString(1, nuevoNombre);
            pst.setString(2, nuevaDescripcion);
            pst.setString(3, nuevosObjetivos);
            pst.setInt(4, idActividad);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("editarActividad:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }

    /**
     * Edita la fecha de una actividad existente.
     *
     * @param fecha La nueva fecha de la actividad.
     * @param idActividad El id de la actividad a editar.
     */
    public void editarActividad(LocalDate fecha, int idActividad) {
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "UPDATE actividades SET fechaActividad = ? WHERE id = ?");
            pst.setDate(1, java.sql.Date.valueOf(fecha));
            pst.setInt(2, idActividad);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("editarActividad:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }

    /**
     * Elimina una actividad de la base de datos.
     *
     * @param a La actividad que se eliminará de la base de datos.
     */
    public void eliminarActividad(Actividad a) {
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "DELETE from actividades WHERE id = ?");
            pst.setInt(1, a.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("eliminarActividad:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }
}
