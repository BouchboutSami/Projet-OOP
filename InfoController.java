import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class InfoController {

    @FXML
    private ImageView DiceTwo;

    @FXML
    private Button LancerDe;

    @FXML
    private ImageView diceOne;

    @FXML
    private Text infos;

    @FXML
    private GridPane plateau;

    public void afficher(Joueur joueur) {
        String info_joueur = joueur.getNom_joueur() + "\n" + joueur.getMeilleur_score_personnel() + "\n"
                + joueur.partie.getIndice_actuel() + "\n" + joueur.partie.getScore_actuel();
        infos.setText(info_joueur);
        this.setPlateau(joueur);
        this.deroulement_jeu(joueur);
    }

    public void setPlateau(Joueur joueur) {
        for (Node node : plateau.getChildren()) {
            int indice = Integer.parseInt(((Button) node).getText());
            node.setStyle("-fx-background-color:" + joueur.partie.getPlateau().getTab_cases()[indice].getCouleur()
                    + ";-fx-content-display: center;");
            node.setOnMouseClicked(event -> {
                for (Node j : plateau.getChildren()) {
                    if (j.equals(node)) {
                        Image image = new Image(getClass().getResource("./assets/RedCircle.png").toExternalForm());
                        ImageView icon = new ImageView(image);
                        ((Button) node).setGraphic(icon);
                    } else {
                        Image image = new Image(getClass().getResource("./assets/RedCircle.png").toExternalForm());
                        ImageView icon = new ImageView(image);
                        icon.setVisible(false);
                        ((Button) j).setGraphic(icon);

                    }
                }
            });
        }
    }

    public Button Recherche(int indice) {
        Button found = new Button();
        for (Node node : plateau.getChildren()) {
            if (((Button) node).getText().equals("" + indice)) {
                found = (Button) node;
            }
        }
        return found;
    }

    public void deroulement_jeu(Joueur joueur) {
        // while (joueur.partie.getIndice_actuel() < 99) {
        // Button Btn = Recherche(joueur.partie.getIndice_actuel());
        // Btn.setStyle("-fx-background-color:" +
        // joueur.partie.getPlateau().getTab_cases()[joueur.partie
        // .getIndice_actuel()].getCouleur()
        // + ";-fx-border-color:black" +
        // ";-fx-border-width: 5");
        // joueur.partie.getPlateau().getTab_cases()[joueur.partie.getIndice_actuel()].ActionCase(joueur.partie);
        // }
    }

}
