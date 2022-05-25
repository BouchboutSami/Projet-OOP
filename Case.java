public abstract class Case implements Cloneable {
  private String couleur = "a";
   
  @Override
  protected Object clone()
      throws CloneNotSupportedException
  {
      // Super() keyword refers to parent class
      return super.clone();
  }

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
