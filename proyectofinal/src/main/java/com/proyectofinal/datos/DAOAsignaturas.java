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
            if (rs.next()) {
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

}
