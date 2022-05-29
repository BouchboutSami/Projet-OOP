

public class CaseParcours extends Case {
  private String couleur = "Gris";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    System.out.println("Case Parcours");
    partie.Lancer_des();
  }

}
