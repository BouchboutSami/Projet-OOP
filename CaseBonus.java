public class CaseBonus extends Case {
  private String couleur = "Vert";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    System.out.println("Vous etes sur une" + this.getClass().getName()
        + " donc vous avez un bonus de 10 points et vous avancez de deux cases");
    partie.AjouterScore(10);
    partie.Maj_indice(2);
  }

  public void setCouleur(String couleur) {
    this.couleur = couleur;
  }

}
