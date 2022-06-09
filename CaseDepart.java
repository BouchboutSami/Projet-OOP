
public class CaseDepart extends Case {
  private String couleur = "yellow";

  public CaseDepart() {
  }

  @Override
  public String getCouleur() {
    return this.couleur;
  }

  @Override
  public void ActionCase(Partie partie) {
    partie.Maj_indice(1);
  }

}
