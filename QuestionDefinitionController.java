
import java.util.ArrayList;
import java.util.Collections;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuestionDefinitionController {

    @FXML
    private Button submit;

    @FXML
    private Text definition;

    @FXML
    private HBox input;

    public void genqst(Partie partie) {
        ArrayList<QuestionDefinition> tabqst = new ArrayList<QuestionDefinition>();// on cree un tableau de questions
        QuestionDefinition q0 = new QuestionDefinition("a room or place equipped for cooking.",
                "Kitchen");
        QuestionDefinition q1 = new QuestionDefinition(
                "a device for capturing a photographic image or recording a video, using film or digital memory.",
                "Camera");
        QuestionDefinition q2 = new QuestionDefinition(
                "the vast body of salt water that covers almost three fourths of the earth's surface.",
                "Ocean");
        QuestionDefinition q3 = new QuestionDefinition(
                "a sequence of consecutive still images recorded in a series to be viewed on a screen",
                "Movie");
        QuestionDefinition q4 = new QuestionDefinition(
                "the cultivation of a particular branch of learning",
                "Study");
        QuestionDefinition q5 = new QuestionDefinition(
                "a place set apart to contain books, periodicals, and other material for reading", "library");
        QuestionDefinition q6 = new QuestionDefinition(
                "a device that combines a cell phone with a handheld computer, typically offering internet access",
                "Phone");
        QuestionDefinition q7 = new QuestionDefinition(
                "a basic social unit consisting of parents and their children",
                "Family");
        QuestionDefinition q8 = new QuestionDefinition("the main meal of the day, eaten in the evening", "Dinner");
        QuestionDefinition q9 = new QuestionDefinition(
                "instrument for writing or drawing with ink or a similar substance.", "Pen");
        Collections.addAll(tabqst, q0, q1, q2, q3, q4, q5, q6, q7, q8, q9);
        int rand = (int) (Math.random() * tabqst.size());
        String question = tabqst.get(rand).getDefinition();
        String reponse = tabqst.get(rand).getReponse().toLowerCase();
        definition.setText(question);
        for (int i = 0; i < reponse.length(); i++) {// creer des champs de textes autant que la longueur de la reponse
            TextField textField = new TextField();
            textField.setId(Integer.toString(i));
            textField.setPrefHeight(40);
            textField.setPrefWidth(40);
            textField.setStyle("-fx-font-size: 20");
            textField.setAlignment(Pos.CENTER);
            textField.setTextFormatter(new TextFormatter<String>((Change change) -> {
                String newText = change.getControlNewText();
                if (newText.length() > 1) {
                    return null;
                } else {
                    return change;
                }
            }));
            input.getChildren().add(textField);
        }
        submit.setOnMouseClicked(e -> {// en cliquant on compare le mot introduit avec la réponse
            String rep = "";
            for (Node node : input.getChildren()) {
                rep += ((TextField) node).getText();
                submit.setId(rep);
                if (submit.getId().toLowerCase().equals(reponse)) {
                    partie.AjouterScore(10);
                } else {
                    partie.AjouterScore(-10);
                }
                Stage stage = (Stage) node.getScene().getWindow();// aprés avoir soumis la réponse on quitte la fenetre
                stage.close();
            }

        });
    }
}
