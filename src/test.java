// import java.io.*;
// import java.util.*;

// public class test {
//   public static void main(String[] args) throws IOException {
//     System.out.println("Bienvenue au jeu de l'anglais");
//     System.out.println("Tapez votre pseudo:");
//     Scanner scanner = new Scanner(System.in);
//     String pseudo = scanner.nextLine();
//     Joueur player = new Joueur("lol");
//     Joueur player2 = new Joueur("hamax");
//     Joueur player3 = new Joueur("lms");
//     Jeu game = new Jeu() ;
//     // game.joueurs.put("lolooo", player);
//     // game.joueurs.put("hamaxsss", player2);
    
       
//      player3 =   game.authenticate("lolhDD55DhGGa");
//      System.out.println(player3.getNom_joueur()); 
//       player3.partie.getPlateau().Afficher_plateau();
   
//     // player.partie.getPlateau().getTab_cases()[player.partie.getIndice_actuel()].ActionCase(player.partie);
//     // player.partie.getPlateau().getTab_cases()[player.partie.getIndice_actuel()].ActionCase(player.partie);
//     // player.partie.getPlateau().getTab_cases()[player.partie.getIndice_actuel()].ActionCase(player.partie);
//     // player.partie.getPlateau().getTab_cases()[player.partie.getIndice_actuel()].ActionCase(player.partie);
//     // player.Afficher_infos();
    
//     scanner.close();
//   }
// }
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application {
    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("./mainScene.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
