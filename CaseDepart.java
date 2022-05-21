public class CaseDepart extends Case {
  private String couleur = "Jaune";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    partie.Lancer_des();
  }

}
