import java.io.*;
import java.util.*;

public class Joueur {
  private String nom_joueur;
  private int Meilleur_score_personnel;
  public Partie partie;

  public Joueur(String nom_joueur) throws IOException {
    FileReader file = new FileReader("./Joueurs.txt");
    BufferedReader reader = new BufferedReader(file);
    String infos_joueur;
    boolean trouv = false;
    while (((infos_joueur = reader.readLine()) != null) && (trouv == false)) {
      StringTokenizer stn = new StringTokenizer(infos_joueur);
      String pseudo_joueur = stn.nextToken();
      if (pseudo_joueur.equals(nom_joueur)) {

        trouv = true;
        this.nom_joueur = pseudo_joueur;
        this.partie = new Partie();
        this.partie.setIndice_actuel(Integer.parseInt(stn.nextToken()));
        this.partie.setScore_actuel(Integer.parseInt(stn.nextToken()));
        this.Meilleur_score_personnel = Integer.parseInt(stn.nextToken());
        this.partie.setPlateau(new Plateau());
      } else {
        this.nom_joueur = nom_joueur;
        this.Meilleur_score_personnel = 0;
        this.partie = new Partie();
        this.partie.setIndice_actuel(0);
        this.partie.setScore_actuel(0);
        this.partie.setPlateau(new Plateau());
      }
    }
    if (trouv == false) {
      String info = "";
      try {
        FileWriter out = new FileWriter("./Joueurs.txt", true);
        info = "\n" + nom_joueur + " 0" + " 0" + " 0";
        out.write(info);
        out.close();

      } catch (IOException e) {
        System.out.println("file not found in output ");
        e.printStackTrace();
      }
    }
    reader.close();
    file.close();
  }

  public void Afficher_infos() {
    System.out.println("------------------------------------------");
    System.out.println("Pseudo : " + this.nom_joueur);
    System.out.println("Meilleur score : " + this.Meilleur_score_personnel);
    System.out.println("Indice actuel : " + this.partie.getIndice_actuel());
    System.out.println("score_actuel : " + this.partie.getScore_actuel());
    // this.partie.getPlateau().Afficher_plateau();
  }

  public String getNom_joueur() {
    return nom_joueur;
  }

  public void Maj_infos_joueur() {
  }

}
