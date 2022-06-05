import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.print.Collation;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CaseImageController {

    @FXML
    private Text answer;

    @FXML
    private GridPane grid;

    public void genqst(Partie partie) {
        File folder = new File("./imagesQuestions");
        File files[] = folder.listFiles();
        int iterateur = 0;
        int i = (int) (Math.random() * 4);
        for (Node node : grid.getChildren()) {
            ArrayList<Integer> random = new ArrayList<Integer>();
            for (int k = 0; k < files.length; k++) {
                random.add(k);
            }
            Collections.shuffle(random);
            int j = random.get(iterateur);

            ((ImageView) node).setImage(
                    new Image("./imagesQuestions/" + files[j].getName()));
            ((ImageView) node).setId(files[j].getName().replace(".jpg", ""));
            if (iterateur == i) {
                System.out.println(files[j].getName().replace(".jpg", ""));
                answer.setText(files[j].getName().replace(".jpg", ""));
            }
            ((ImageView) node).setOnMouseClicked(event -> {
                if (answer.getText().equals(((ImageView) node).getId())) {
                    partie.AjouterScore(10);
                } else {
                    partie.AjouterScore(-10);
                }
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();

            });
            iterateur++;
        }

    }

}
