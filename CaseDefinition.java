
public class CaseDefinition extends CaseQuestion {
  private String couleur = "blue";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    System.out.println("Case Definition Action Case");
    partie.Maj_indice(4);
  }
}
