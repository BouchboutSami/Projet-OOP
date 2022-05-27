import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {

  @FXML
  private TextField textField;

  @FXML
  void btnClicked(ActionEvent event) {
    Stage Mainwindow = (Stage) textField.getScene().getWindow();
    String title = textField.getText();
    Mainwindow.setTitle(title);
  }

}
