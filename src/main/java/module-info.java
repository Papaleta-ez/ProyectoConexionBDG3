module com.example.proyectoconexionbdg3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectoconexionbdg3 to javafx.fxml;
    exports com.example.proyectoconexionbdg3;
}