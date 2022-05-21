public class CaseSaut extends Case {
  private String couleur = "Orange";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    partie.setIndice_actuel((int) (Math.random() * 99));

  }

}
