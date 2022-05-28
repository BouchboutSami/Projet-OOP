

public class CaseParcours extends Case {
  private String couleur = "Gris";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    partie.Lancer_des();
  }

}
