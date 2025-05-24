module com.andre.projetolpoo {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.andre.projetolpoo.Controllers;
    opens com.andre.projetolpoo.Controllers to javafx.fxml;

    opens com.andre.projetolpoo.Models to javafx.base;
}
