
public class CaseSaut extends Case {
  private String couleur = "orange";

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    int indice = (int) (Math.random() * 99);
    partie.setIndice_actuel(indice);
    System.out.println("Saut à " + indice);
  }

}
