package com.example.proyectoconexionbdg3.controllers;

import com.example.proyectoconexionbdg3.connection.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrincipalController {

    @FXML
    private Label lblEstado;

    @FXML
    private void probarConexion() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            lblEstado.setText("Conectado");
        } catch (SQLException e) {
            lblEstado.setText("Error de conexión");
            e.printStackTrace();
        }
    }

    @FXML
    private void obtenerEstudiantes() {

        String sql = "SELECT * FROM estudiante";

        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            System.out.println("Listado de estudiantes:");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");

                System.out.println(id + " | " + nombre + " | " + correo);
            }

            lblEstado.setText("Estudiantes obtenidos");

        } catch (SQLException e) {
            lblEstado.setText("Error al obtener estudiantes");
            e.printStackTrace();
        }
    }
}