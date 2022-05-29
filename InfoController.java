import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class InfoController {
   

    @FXML
    private Text info;
    public void afficher(Joueur joueur){
        String info_joueur = joueur.getNom_joueur() + "\n" + joueur.getMeilleur_score_personnel() +"\n" + joueur.partie.getIndice_actuel() +"\n" + joueur.partie.getScore_actuel();
        info.setText(info_joueur);
    }
     

}
