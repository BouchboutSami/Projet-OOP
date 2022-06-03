
public class CaseImage extends CaseQuestion {
  private String couleur = "#e322dd";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    System.out.println("Case Image Action Case");
    partie.Maj_indice(3);
  }
}
