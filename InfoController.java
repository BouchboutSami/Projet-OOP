
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

public class InfoController {

    @FXML
    public ImageView DiceTwo;

    @FXML
    private Button LancerDe;

    @FXML
    public ImageView diceOne;

    @FXML
    private Text infos;

    @FXML
    private GridPane plateau;

    public void afficher(Joueur joueur) {
        String info_joueur = joueur.getNom_joueur() + "\n" + joueur.getMeilleur_score_personnel() + "\n"
                + joueur.partie.getIndice_actuel() + "\n" + joueur.partie.getScore_actuel();
        infos.setText(info_joueur);
        this.setPlateau(joueur);
        try {
            this.deroulement_jeu(joueur);
        } catch (Exception e) {

        }

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
        Button btn = Recherche(joueur.partie.getIndice_actuel());
        btn.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        for (Node node : plateau.getChildren()) {
            node.setOnMouseClicked(event -> {
                if (((Button) node).getText().equals("" + joueur.partie.getIndice_actuel())) {
                    Dessiner_perso(((Button) node));
                    String info_joueur = joueur.getNom_joueur() + "\n" +
                            joueur.getMeilleur_score_personnel() + "\n"
                            + joueur.partie.getIndice_actuel() + "\n" + joueur.partie.getScore_actuel();
                    System.out.println(info_joueur);        
                    infos.setText(info_joueur);
                    if (joueur.partie.getPlateau().getTab_cases()[joueur.partie.getIndice_actuel()]
                            .getCouleur().equals("grey")) {
                        LancerDe.setOnMouseClicked(e -> {
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
                            joueur.partie.Maj_indice(chiffreUn + chiffreDeux);
                            System.out.println(joueur.partie.getIndice_actuel());
                            Button btnNext = Recherche(joueur.partie.getIndice_actuel());
                            btnNext.setBorder(new Border(new BorderStroke(Color.BLACK,
                                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                            ((Button) node).setBorder(null);
                            LancerDe.setOnMouseClicked(null);
                        });

                    } else {
                        joueur.partie.getPlateau().getTab_cases()[joueur.partie.getIndice_actuel()]
                                .ActionCase(joueur.partie);
                    }

                    btn.setOnMouseClicked(null);
                    for (Node node2 : plateau.getChildren()) {
                        if (node2 != node) {
                            ((Button) node2).setGraphic(null);
                            ((Button) node2).setBorder(null);
                        }
                    }
                } else {
                    // Exception
                    System.out.println("case ghalta");
                }
                Button btnNext = Recherche(joueur.partie.getIndice_actuel());
                btnNext.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            });
        }
    }

    public void Dessiner_perso(Button button) {
        Image image = new Image(getClass().getResource("./assets/RedCircle.png").toExternalForm());
        ImageView icon = new ImageView(image);
        button.setGraphic(icon);
    }

    /**
     * @return the lancerDe
     */
    public Button getLancerDe() {
        return LancerDe;
    }

}
