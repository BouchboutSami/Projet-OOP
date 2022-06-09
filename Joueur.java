
import java.io.*;
import java.util.*;

public class Joueur implements Serializable {
  private String nom_joueur;
  private int Meilleur_score_personnel;
  public Partie partie;

  public Joueur(String nom_joueur) {
    this.nom_joueur = nom_joueur;
    this.partie = new Partie();
    this.Meilleur_score_personnel = 0;
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

  public int getMeilleur_score_personnel() {
    return Meilleur_score_personnel;
  }

  public void setMeilleur_score_personnel(int meilleur_score_personnel) {
    Meilleur_score_personnel = meilleur_score_personnel;
  }

}
