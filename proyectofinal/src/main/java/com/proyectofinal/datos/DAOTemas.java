/*
 * DAOTemas
 * Operaciones de acceso a datos para la entidad Tema
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
public class DAOTemas {

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

    public List<Tema> getTemasPorAsignatura(Asignatura a) {
        Connection conn = null;
        List<Tema> temas = new ArrayList();
        DAOActividades da = new DAOActividades();
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "select * from temas WHERE id_asignatura = ?");
            pst.setInt(1, a.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Tema t = new Tema(rs.getInt("id"), rs.getString("nombre"), a);
                t.setActividades(da.getActividadesPorTema(t));
                temas.add(t);
            }
        } catch (SQLException e) {
            System.err.println("getMaestro:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }

        return temas;
    }

    public void añadirTema(String nombre, Asignatura a) {
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "Insert into temas(nombre, id_asignatura) values(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, nombre);
            pst.setInt(2, a.getId());
            pst.executeUpdate();
            ResultSet claveGenerada = pst.getGeneratedKeys();
            if (claveGenerada.next()) {
                a.getTemas().add(new Tema(claveGenerada.getInt(1), nombre, a));
            }

        } catch (SQLException e) {
            System.err.println("añadirTema:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }

    public void editarTema(String nuevoNombre, int idTema) {
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "UPDATE temas SET nombre = ? WHERE id = ?");
            pst.setString(1, nuevoNombre);
            pst.setInt(2, idTema);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("editarTema:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }

    public void eliminarTema(Tema t) {
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "DELETE from temas WHERE id = ?");
            pst.setInt(1, t.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("eliminarTema:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }
}
