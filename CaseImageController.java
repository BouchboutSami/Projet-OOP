import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CaseImageController {

    // private static final String ImageView = null;

    @FXML
    private Text answer;

    @FXML
    private GridPane grid;
    
public void   genqst( Partie partie){
File folder = new File("Projet-OOP/imagesQuestions");
File files[] = folder.listFiles(); 
int iterateur = 0;
int i  =  (int) (Math.random() *4);
for ( Node node : grid.getChildren()) {
    
    int j  =  (int) (Math.random() *files.length);
    
    ((ImageView)node).setImage(new Image("C:/Users/ASUS User/Desktop/tpoo/Projet-OOP/imagesQuestions/"+files[j].getName()));
    ((ImageView)node).setId(files[j].getName().replace(".jpg", ""));
    if( iterateur == i){
        
        System.out.println(files[j].getName().replace(".jpg", ""));
        answer.setText(files[j].getName().replace(".jpg", ""));
    }
    ((ImageView)node).setOnMouseClicked(event ->{
        if( answer.getText().equals(  ((ImageView)node).getId())){
           
           partie.AjouterScore(10);
           
        }
        else{
            
            partie.AjouterScore(-10);
            
        }
        partie.afficher_details_partie();
        Stage stage = (Stage) node.getScene().getWindow();
  
        stage.close();

    });
    iterateur++;
}





    
}








}
