/*
 * DAOAsignaturas
 * Operaciones de acceso a datos para la entidad Asignatura
 */
package com.proyectofinal.datos;

import com.mysql.cj.jdbc.Driver;
import com.proyectofinal.entidades.Asignatura;
import com.proyectofinal.entidades.Maestro;
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
public class DAOAsignaturas {

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

    public List<Asignatura> getAsignaturasDeMaestro(Maestro m) {
        Connection conn = null;
        List<Asignatura> asignaturas = new ArrayList();
        DAOTemas dt = new DAOTemas();
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "select * from asignaturas WHERE login_maestro = ?");
            pst.setString(1, m.getLogin());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Asignatura a = new Asignatura(rs.getInt("id"), rs.getString("nombre"), m);
                a.setTemas(dt.getTemasPorAsignatura(a));
                asignaturas.add(a);
            }
        } catch (SQLException e) {
            System.err.println("getMaestro:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }

        return asignaturas;
    }

    public void añadirAsignatura(String nombre, Maestro m) {
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "Insert into asignaturas(nombre, login_maestro) values(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, nombre);
            pst.setString(2, m.getLogin());
            pst.executeUpdate();
            ResultSet claveGenerada = pst.getGeneratedKeys();
            if (claveGenerada.next()) {
                m.getAsignaturas().add(new Asignatura(claveGenerada.getInt(1), nombre, m));
            }

        } catch (SQLException e) {
            System.err.println("añadirAsignatura:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }

    public void editarAsignatura(String nuevoNombre, int idAsignatura) {
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "UPDATE asignaturas SET nombre = ? WHERE id = ?");
            pst.setString(1, nuevoNombre);
            pst.setInt(2, idAsignatura);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("editarAsignatura:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }
    
        public void eliminarAsignatura(Asignatura a) {
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "DELETE from asignaturas WHERE id = ?");
            pst.setInt(1, a.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("editarAsignatura:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }
    /*
        public boolean comprobarAsignaturas(String nombreAsignatura, Maestro m) {
        Connection conn = null;
        boolean existe = false;
        try {
            conn = conectarBD();
            PreparedStatement stm = conn.prepareStatement("select nombre from asignaturas where login_maestro=?");
            stm.setString(1, m.getLogin());
            ResultSet resultset = stm.executeQuery();
            while (resultset.next()){
                if(resultset.getString("nombre").equalsIgnoreCase(nombreAsignatura)){
                    existe=true;
                }
            }
        } catch (SQLException e) {
            System.err.println("comprobarAsignatura:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
        return existe;
    }
     */

}
