
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class InfoController extends Thread {

    Thread gameThread;

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
            String style = node.getStyle();
            style += "-fx-background-color:" + joueur.partie.getPlateau().getTab_cases()[indice].getCouleur()
                    + ";-fx-content-display: center;";
            node.setStyle(style);
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

        plateau.setOnMouseClicked(event -> {
            Button btn = Recherche(joueur.partie.getIndice_actuel());
            btn.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            btn.setOnMouseClicked(e -> {
                Dessiner_perso(btn);
                joueur.partie.getPlateau().getTab_cases()[joueur.partie.getIndice_actuel()].ActionCase(joueur.partie);
                String info_joueur = joueur.getNom_joueur() + "\n" +
                        joueur.getMeilleur_score_personnel() + "\n"
                        + joueur.partie.getIndice_actuel() + "\n" + joueur.partie.getScore_actuel();
                infos.setText(info_joueur);
                btn.setOnMouseClicked(null);
                for (Node node : plateau.getChildren()) {
                    if (node != btn) {
                        ((Button) node).setGraphic(null);
                        ((Button) node).setBorder(null);
                    }
                }
            });
        });
    }
    // while (joueur.partie.getIndice_actuel() < 99) {
    // Button Btn = Recherche(joueur.partie.getIndice_actuel());
    // Btn.setStyle("-fx-background-color:" +
    // joueur.partie.getPlateau().getTab_cases()[joueur.partie
    // .getIndice_actuel()].getCouleur()
    // + ";-fx-border-color:black" +
    // ";-fx-border-width: 5");
    // joueur.partie.getPlateau().getTab_cases()[joueur.partie.getIndice_actuel()].ActionCase(joueur.partie);
    // }

    public void LancerDes(Button button) {
        button.setOnAction(event -> {
            int chiffreUn = 1 + ((int) (Math.random() * 6));
            int chiffreDeux = 1 + ((int) (Math.random() * 6));
            String LinkOne = "assets/Dice" + Integer.toString(chiffreUn) + ".png";
            String LinkTwo = "assets/Dice" + Integer.toString(chiffreDeux) + ".png";
            diceOne.getStyleClass().clear();
            DiceTwo.getStyleClass().clear();
            diceOne.getStyleClass().add(Integer.toString(chiffreUn));
            DiceTwo.getStyleClass().add(Integer.toString(chiffreDeux));
            diceOne.setImage(new Image(LinkOne));
            DiceTwo.setImage(new Image(LinkTwo));
        });

    }

    public void Dessiner_perso(Button button) {
        Image image = new Image(getClass().getResource("./assets/RedCircle.png").toExternalForm());
        ImageView icon = new ImageView(image);
        button.setGraphic(icon);
    }

}
