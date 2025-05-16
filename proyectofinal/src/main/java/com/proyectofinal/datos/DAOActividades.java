/*
 * DAOActividades
 * Operaciones de acceso a datos para la entidad Actividad
 */
package com.proyectofinal.datos;

import com.mysql.cj.jdbc.Driver;
import com.proyectofinal.entidades.Actividad;
import com.proyectofinal.entidades.Asignatura;
import com.proyectofinal.entidades.Tema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
