import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class LoginPageController {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private TextField userinput;
    private Jeu game = new Jeu();

    @FXML
    void Authenticate(ActionEvent event) throws IOException {
        Joueur user = game.authenticate(userinput.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Info.fxml"));
        root = loader.load();
        InfoController infocontroller = loader.getController();
        infocontroller.afficher(user);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
