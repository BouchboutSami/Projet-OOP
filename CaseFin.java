
/**
 * CaseFin
 */
public class CaseFin extends Case {
  private String couleur = "black";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    Jeu game = new Jeu();
    System.out.println("Case Fin");
    if( Jeu.meilleur_score_global < partie.getScore_actuel()){
      Jeu.meilleur_score_global = partie.getScore_actuel();
    }
    System.out.println(Jeu.meilleur_score_global);
  }

}