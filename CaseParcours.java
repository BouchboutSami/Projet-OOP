import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class CaseParcours extends Case {
  private String couleur = "grey";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    System.out.println("hello");
  }
}
