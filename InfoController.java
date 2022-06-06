
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
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
import javafx.stage.Stage;

public class InfoController {
    private Parent root;
    @FXML
    private Button quit;

    @FXML
    private Button restart;

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

    public void afficher(Joueur joueur, Jeu game) {
        this.setPlateau(joueur);
        this.deroulement_jeu(joueur, game);
        quit.setOnMouseClicked(e -> {
            game.saveEtat(joueur);
            try {
                root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Learn'nRoll");
            primaryStage.setScene(scene);
            primaryStage.show();
            Stage stage = (Stage) quit.getScene().getWindow();
            stage.close();
        });
        restart.setOnMouseClicked(event -> {
            joueur.partie = new Partie();
            this.setPlateau(joueur);
            Dessiner_perso(Recherche(joueur.partie.getIndice_actuel()));
            for (Node node2 : plateau.getChildren()) {
                if (node2 != Recherche(joueur.partie.getIndice_actuel())) {
                    ((Button) node2).setGraphic(null);
                    ((Button) node2).setBorder(null);
                }
            }
        });

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

    public void deroulement_jeu(Joueur joueur, Jeu game) {
        String info_joueur = "\n\nUser Name: " + joueur.getNom_joueur() + "\n\n" +
                "Personal HS: " + joueur.getMeilleur_score_personnel() + "\n\n"
                + "Actual index: " + joueur.partie.getIndice_actuel() + "\n\n"
                + "Actual Score: " + joueur.partie.getScore_actuel() + "\n\n"
                + "Global HS: " + game.set_meilleur_score_global();
        infos.setText(info_joueur);
        Button btn = Recherche(joueur.partie.getIndice_actuel());
        btn.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        for (Node node : plateau.getChildren()) {
            node.setOnMouseClicked(event -> {
                if (((Button) node).getText().equals("" + joueur.partie.getIndice_actuel())
                        || joueur.partie.getPlateau().getTab_cases()[Integer.parseInt(((Button) node).getText())]
                                .getCouleur().equals("#ff9193")
                        || joueur.partie.getPlateau().getTab_cases()[Integer.parseInt(((Button) node).getText())]
                                .getCouleur().equals("#00c3e3")
                        || joueur.partie.getPlateau().getTab_cases()[Integer.parseInt(((Button) node).getText())]
                                .getCouleur().equals("#f70d1a")
                        || joueur.partie.getPlateau().getTab_cases()[Integer.parseInt(((Button) node).getText())]
                                .getCouleur().equals("#7dda32")
                        || joueur.partie.getPlateau().getTab_cases()[Integer.parseInt(((Button) node).getText())]
                                .getCouleur().equals("#ff7900")
                        || joueur.partie.getPlateau().getTab_cases()[Integer.parseInt(((Button) node).getText())]
                                .getCouleur().equals("black")) {
                    Dessiner_perso(((Button) node));
                    joueur.partie.setIndice_actuel(Integer.parseInt(((Button) node).getText()));
                    String infos_joueur = "\n\nUser Name: " + joueur.getNom_joueur() + "\n\n" +
                            "Personal HS: " + joueur.getMeilleur_score_personnel() + "\n\n"
                            + "Actual index: " + joueur.partie.getIndice_actuel() + "\n\n"
                            + "Actual Score: " + joueur.partie.getScore_actuel() + "\n\n"
                            + "Global HS: " + game.set_meilleur_score_global();
                    infos.setText(infos_joueur);
                    String color = joueur.partie.getPlateau().getTab_cases()[joueur.partie.getIndice_actuel()]
                            .getCouleur();
                    if (color.equals("grey") || color.equals("yellow")) {
                        LancerDe.setOnMouseClicked(e -> {
                            int chiffreUn = 1 + ((int) (Math.random() * 6));
                            int chiffreDeux = 1 + ((int) (Math.random() * 6));
                            String LinkOne = "assets/Dice" + Integer.toString(chiffreUn) + ".png";
                            String LinkTwo = "assets/Dice" + Integer.toString(chiffreDeux) + ".png";
                            diceOne.setImage(new Image(LinkOne));
                            DiceTwo.setImage(new Image(LinkTwo));
                            joueur.partie.Maj_indice(chiffreUn + chiffreDeux);
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
                    if (joueur.partie.getIndice_actuel() == 99) {
                        if (joueur.partie.getScore_actuel() > joueur.getMeilleur_score_personnel()) {
                            joueur.setMeilleur_score_personnel(joueur.partie.getScore_actuel());
                            game.saveEtat(joueur);
                        }
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Congratulations");
                        alert.setHeaderText("You've just won the game");
                        alert.setContentText(
                                "Your score :" + joueur.partie.getScore_actuel() + "\n"
                                        + "The global highscore is : " + game.set_meilleur_score_global());
                        alert.showAndWait();
                        joueur.partie = new Partie();
                        this.setPlateau(joueur);
                        Dessiner_perso(Recherche(joueur.partie.getIndice_actuel()));
                        for (Node node2 : plateau.getChildren()) {
                            if (node2 != Recherche(joueur.partie.getIndice_actuel())) {
                                ((Button) node2).setGraphic(null);
                                ((Button) node2).setBorder(null);
                            }
                        }
                    }
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Warning");
                    alert.setHeaderText("Calculate your steps again");
                    alert.setContentText(
                            " - Click on OK \n - Choose the right destination ");
                    alert.showAndWait();
                }
                String infoss_joueur = "\n\nUser Name: " + joueur.getNom_joueur() + "\n\n" +
                        "Personal HS: " + joueur.getMeilleur_score_personnel() + "\n\n"
                        + "Actual index: " + joueur.partie.getIndice_actuel() + "\n\n"
                        + "Actual Score: " + joueur.partie.getScore_actuel() + "\n\n"
                        + "Global HS: " + game.set_meilleur_score_global();
                infos.setText(infoss_joueur);
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

    public void quitGame(ActionEvent event) {
        Stage stg = (Stage) plateau.getScene().getWindow();
        stg.close();
    }

    /**
     * @return the lancerDe
     */
    public Button getLancerDe() {
        return LancerDe;
    }

}
