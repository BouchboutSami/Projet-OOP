import java.io.*;

public class Joueur {
  private String nom_joueur;
  private int Meilleur_score_personnel;
  private Partie partie;

  

  public Joueur(String nom_joueur) {
    this.nom_joueur = nom_joueur;
    this.Meilleur_score_personnel =0;

    String info = "" ; 
  
   try {
    FileWriter out = new FileWriter("./data.txt",true) ;
    info = nom_joueur+" 0"+" 0"+" 0 \n";
    
    System.out.println(info);
    out.write(info);
     out.close();
  
  } catch (IOException e) {
    System.out.println("file not found in output ");
    e.printStackTrace();
  }
  }

  /**
   * @return the nom_joueur
   */
  public String getNom_joueur() {
    return nom_joueur;
  }

  // public Joueur Charger_infos_joueur(File file, Joueur joueur) {
  //   // process the file to get the data than put it in the constructor below
  //   //return new Joueur(nom_joueur, Meilleur_score_personnel, partie);
  // }

  public void Maj_infos_joueur(File file, Joueur joueur) {
    // mise a jour fichier avec la partie actuelle du joueur
  }

  /**
   * @return the partie
   */
  public Partie getPartie() {
    return partie;
  }

  /**
   * @param partie the partie to set
   */
  public void setPartie(Partie partie) {
    this.partie = partie;
  }
 

    public boolean Exists(String pseudo) {
      return true;
    }
  public void AjouterJoueur(Joueur joueur){
   
  
  }  
  
  
  
  
  


}
