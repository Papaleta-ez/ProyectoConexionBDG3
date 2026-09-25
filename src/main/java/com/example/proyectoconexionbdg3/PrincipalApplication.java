package com.example.proyectoconexionbdg3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                PrincipalApplication.class.getResource(
                        "/com/example/proyectoconexionbdg3/principal.fmx.fxml"
                )
        );

        Scene scene = new Scene(loader.load(), 600, 400);

        stage.setTitle("Conexión con PostgreSQL");
        stage.setScene(scene);
        stage.show();
    }
}