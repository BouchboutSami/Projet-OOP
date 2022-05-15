import java.io.File;

public class Joueur {
  private String nom_joueur;
  private int Meilleur_score_personnel;
  private Partie partie;

  public Joueur(String nom_joueur, int Meilleur_score_personnel, Partie partie) {
    this.nom_joueur = nom_joueur;
    this.Meilleur_score_personnel = Meilleur_score_personnel;
    this.partie = partie;
  }

  public Joueur(String nom_joueur) {
    this.nom_joueur = nom_joueur;
    this.Meilleur_score_personnel = 0;
  }

  /**
   * @return the nom_joueur
   */
  public String getNom_joueur() {
    return nom_joueur;
  }

  public Joueur Charger_infos_joueur(File file, Joueur joueur) {
    // process the file to get the data than put it in the constructor below
    return new Joueur(nom_joueur, Meilleur_score_personnel, partie);
  }

  public void Maj_infos_joueur(File file, Joueur joueur) {
    // mise a jour fichier avec la partie actuelle du joueur
  }
}
