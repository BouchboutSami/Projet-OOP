public class CaseParcours extends Case {
  private String couleur = "Gris";

  @Override
  public String getCouleur() {
    // TODO Auto-generated method stub
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    // TODO Auto-generated method stub
    partie.Lancer_des();
  }

}
