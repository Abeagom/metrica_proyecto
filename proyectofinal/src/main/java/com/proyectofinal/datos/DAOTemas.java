/*
 * DAOTemas
 * Operaciones de acceso a datos para la entidad Tema
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
            if (rs.next()) {
                Tema t = new Tema(rs.getInt("id"), rs.getString("nombre"), a);
                temas.add(t);
            }
        } catch (SQLException e) {
            System.err.println("getMaestro:" + e.getMessage());
        } finally {
            desconectarBD(conn);
        }

        return temas;
    }
}
