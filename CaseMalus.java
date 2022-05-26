public class CaseMalus extends Case {
  private String couleur = "Rouge";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    System.out.println("Vous etes sur une" + this.getClass().getName()
        + " donc vous avez un malus de 10 points et vous reculez de deux cases");
    partie.AjouterScore(-10);
    partie.Maj_indice(-2);
  }

}
