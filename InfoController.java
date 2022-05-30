import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class InfoController {
    @FXML
    private Text infos;

    @FXML
    private GridPane plateau;

    public void afficher(Joueur joueur) {
        String info_joueur = joueur.getNom_joueur() + "\n" + joueur.getMeilleur_score_personnel() + "\n"
                + joueur.partie.getIndice_actuel() + "\n" + joueur.partie.getScore_actuel();
        infos.setText(info_joueur);
        this.setPlateau(joueur);
    }

    public void setPlateau(Joueur joueur) {
        for (Node node : plateau.getChildren()) {
            int indice = Integer.parseInt(((Button) node).getText());
            node.setStyle("-fx-background-color:" + joueur.partie.getPlateau().getTab_cases()[indice].getCouleur());
            node.setOnMouseEntered(event -> {
                System.out.println(joueur.partie.getPlateau().getTab_cases()[indice].getClass());
            });
        }
    }

}
