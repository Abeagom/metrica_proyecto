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

/**
 *
 * @author al_12
 */
public class DAOMaestros {

    public Connection conectarBD() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/educa+",
                "educa+", "educa+");
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
            }
        } catch (SQLException e) {
            System.err.println("getMaestro:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }

        return m;
    }
}
