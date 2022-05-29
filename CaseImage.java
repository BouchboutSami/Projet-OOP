

public class CaseImage extends CaseQuestion {
  private String couleur = "Rose";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    // TODO Auto-generated method stub
    System.out.println("Case Image Action Case");
  }
}
