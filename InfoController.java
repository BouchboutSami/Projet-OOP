import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
            node.setStyle("-fx-background-color:" + joueur.partie.getPlateau().getTab_cases()[indice].getCouleur());
        }
    }

    public void deroulement_jeu(Joueur joueur) {
        int indice = 0;
        int found = 0;
        for (Node node : plateau.getChildren()) {
            if (((Button) node).getText().equals("" + indice)) {
                found = Integer.parseInt(((Button) node).getText());
            }
        }
    }

}
