import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CaseDefinition extends CaseQuestion {
  private String couleur = "#00c3e3";

  private Parent root;

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("QuestionDefinition.fxml"));
    try {
      root = loader.load();
      Stage secondStage = new Stage();
      secondStage.setScene(new Scene(root, 638, 444));
      secondStage.initModality(Modality.APPLICATION_MODAL);
      QuestionDefinitionController questionDefinitionController = loader.getController();
      questionDefinitionController.genqst(partie);
      partie.Maj_indice(2);
      secondStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
