
/**
 * CaseFin
 */
public class CaseFin extends Case {
  private String couleur = "black";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    System.out.println("Case Fin");
  }

}