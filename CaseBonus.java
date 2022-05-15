public class CaseBonus extends Case {
  private String couleur = "Vert";

  @Override
  public String getCouleur() {
    // TODO Auto-generated method stub
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    // TODO Auto-generated method stub
    partie.AjouterScore(10);
    partie.Maj_indice(2);
  }

}
