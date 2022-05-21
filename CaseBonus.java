public class CaseBonus extends Case {
  private String couleur = "Vert";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    partie.AjouterScore(10);
    partie.Maj_indice(2);
  }

}
