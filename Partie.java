public class Partie {
  private int score_actuel;
  private int indice_actuel;

  /**
   * 
   */
  public Partie() {
    // traitement de fichier pour avoir le score actuel
    // traitement de fichier pour avoir l'indice actuel

  }

  /**
   * @return the score_actuel
   */
  public int getScore_actuel() {
    return score_actuel;
  }

  /**
   * @param score_actuel the score_actuel to set
   */
  public void setScore_actuel(int score_actuel) {
    this.score_actuel = score_actuel;
  }

  /**
   * @return the indice_actuel
   */
  public int getIndice_actuel() {
    return indice_actuel;
  }

  /**
   * @param indice_actuel the indice_actuel to set
   */
  public void setIndice_actuel(int indice_actuel) {
    this.indice_actuel = indice_actuel;
  }

  public void AjouterScore(int nb_ajout) {
    this.score_actuel += nb_ajout;
  }

  public void Maj_indice(int nb_ajout) {
    if (indice_actuel + nb_ajout < 0) {
      indice_actuel = 0;
    } else if (indice_actuel + nb_ajout > 99) {
      indice_actuel = 99 - (indice_actuel + nb_ajout - 99);
    } else {
      indice_actuel += nb_ajout;
    }
  }

  public void Lancer_des() {
    Maj_indice((int) (Math.random() * 12));
  }
}
