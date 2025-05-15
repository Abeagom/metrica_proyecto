/*
 * DAOMaestros
 * Operaciones de acceso a datos para la entidad Maestro
 */
package com.proyectofinal.datos;

import com.mysql.cj.jdbc.Driver;
import com.proyectofinal.entidades.Maestro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author al_12
 */
public class DAOMaestros {

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

    public Maestro getUsuario(String login) {
        Maestro m = null;
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "select * from maestros where login = ?");
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                m = new Maestro(login, rs.getString("password"), rs.getString("nombre"));
                DAOAsignaturas da = new DAOAsignaturas();
                m.setAsignaturas(da.getAsignaturasDeMaestro(m));
            }
        } catch (SQLException e) {
            System.err.println("getMaestro:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }

        return m;
    }

    public void crearUsuario(Maestro m) {
        Connection conn = null;
        try {
            conn = conectarBD();
            PreparedStatement pst = conn.prepareStatement(
                    "Insert into maestros(login, password, nombre) values(?,?,?)");
            pst.setString(1, m.getLogin());
            pst.setString(2, m.getPassword());
            pst.setString(3, m.getNombre());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("crearUsuario:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
    }

    public boolean comprobarUsuario(String nombreUsuario) {
        Connection conn = null;
        boolean existe = false;
        try {
            conn = conectarBD();
            Statement stm = conn.createStatement();
            ResultSet resultset = stm.executeQuery("select login from maestros");
            while (resultset.next()){
                if(resultset.getString("login").equals(nombreUsuario)){
                    existe=true;
                }
            }
        } catch (SQLException e) {
            System.err.println("crearUsuario:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }
        return existe;
    }

}
