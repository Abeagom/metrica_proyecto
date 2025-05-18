/*
 * DAOActividades
 * Operaciones de acceso a datos para la entidad Actividad
 */
package com.proyectofinal.datos;

import com.mysql.cj.jdbc.Driver;
import com.proyectofinal.entidades.Actividad;
import com.proyectofinal.entidades.Asignatura;
import com.proyectofinal.entidades.Maestro;
import com.proyectofinal.entidades.Tema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author al_12
 */
public class DAOActividades {

    public Connection conectarBD() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/educaplus",
                "educa", "educa");
        return conn;
    }

    public void desconectarBD(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error al desconectar BD: " + e.getMessage());
        }
    }

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
                Actividad a = new Actividad(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("objetivos"), t);
                actividades.add(a);
            }
        } catch (SQLException e) {
            System.err.println("getMaestro:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }

        return actividades;
    }

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
                t.getActividades().add(new Actividad(claveGenerada.getInt(1), nombre, descripcion, objetivos, t));
            }

        } catch (SQLException e) {
            System.err.println("añadirActividad:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }

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
