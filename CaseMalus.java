public class CaseMalus extends Case {
  private String couleur = "Rouge";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    partie.AjouterScore(-10);
    partie.Maj_indice(-2);
  }

}
