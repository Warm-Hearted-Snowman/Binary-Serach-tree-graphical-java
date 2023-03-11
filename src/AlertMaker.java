import javafx.scene.control.Alert;

public class AlertMaker {
    public static void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showWarningDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showSuccessMessage(String success, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(success);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
