public abstract class Case {
  private String couleur = "a";

  /**
   * @return the couleur
   */
  public String getCouleur() {
    return couleur;
  }

  public void ActionCase(Partie partie) {
  }

  public void setCouleur(String couleur) {
    this.couleur = couleur;
  }

}
