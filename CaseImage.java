import java.io.IOException;
import java.io.File;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CaseImage extends CaseQuestion {
  private String couleur = "#e322dd";
  private Parent root;

  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("CaseImage.fxml"));
    try {
      root = loader.load();
      Stage secondStage = new Stage();
      secondStage.setScene(new Scene(root, 638, 444));
      secondStage.initModality(Modality.APPLICATION_MODAL);
      CaseImageController caseimageController = loader.getController();
      caseimageController.genqst(partie);
      partie.Maj_indice(2);
      secondStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}