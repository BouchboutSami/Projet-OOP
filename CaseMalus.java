public class CaseMalus extends Case {
  private String couleur = "Rouge";

  @Override
  public String getCouleur() {
    // TODO Auto-generated method stub
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    // TODO Auto-generated method stub
    partie.AjouterScore(-10);
    partie.Maj_indice(-2);
  }

}
