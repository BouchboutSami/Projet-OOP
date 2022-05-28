public class Partie {
  private int score_actuel;
  private int indice_actuel;
  private Plateau plateau;

  public Partie() {
  }

  public Plateau getPlateau() {
    return plateau;
  }

  public void setPlateau(Plateau plateau) {
    this.plateau = plateau;
  }

  public int getScore_actuel() {
    return score_actuel;
  }

  public void setScore_actuel(int score_actuel) {
    this.score_actuel = score_actuel;
  }

  public int getIndice_actuel() {
    return indice_actuel;
  }

  public void setIndice_actuel(int indice_actuel) {
    this.indice_actuel = indice_actuel;
  }

  public void AjouterScore(int nb_ajout) {
    this.score_actuel += nb_ajout;
    if (this.score_actuel < 0) {
      this.score_actuel = 0;
    }
  }

  public void Maj_indice(int nb_ajout) {
    if (this.indice_actuel + nb_ajout < 0) {
      this.indice_actuel = 0;
    } else if (this.indice_actuel + nb_ajout > 99) {
      this.indice_actuel = 99 - (this.indice_actuel + nb_ajout - 99);
    } else {
      this.indice_actuel += nb_ajout;
    }
  }

  public void Lancer_des() {
    Maj_indice((int) (Math.random() * 12));
  }

  public void afficher_details_partie() {
    System.out.println("----------------------------------");
    System.out.println("score actuel : " + this.score_actuel);
    System.out.println("indice actuel : " + this.indice_actuel);
    System.out.println("----------------------------------");
  }
}
