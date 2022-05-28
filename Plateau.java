

import java.io.Serializable;

/**
 * Plateau
 */

public class Plateau implements Serializable   {
  private final int nb_cases = 100;
  private Case[] tab_cases = new Case[nb_cases];

  /**
   * 
   */
  public Plateau() {
    tab_cases[0] = new CaseDepart();
    tab_cases[99] = new CaseFin();
    for (int j = 0; j < 5; j++) {
      for (int i = 0; i < 5; i++) {
        Case[] tab_generator = new Case[] { new CaseSaut(), new CaseMalus(), new CaseBonus(), new CaseImage(),
            new CaseDefinition() };
        int nb_gen;
        do {
          nb_gen = (int) (Math.random() * 100);
        } while (tab_cases[nb_gen] != null);
        tab_cases[nb_gen] = tab_generator[j];
      }
    }

    for (int k = 0; k < tab_cases.length; k++) {
      if (tab_cases[k] == null) {
        tab_cases[k] = new CaseParcours();
      }
    }
  }

  public void Afficher_plateau() {
    for (int i = 0; i < tab_cases.length; i++) {
      System.out.println("Case[" + i + "] contient une case " + tab_cases[i].getCouleur());
    }
  }

  /**
   * @return the tab_cases
   */
  public Case[] getTab_cases() {
    return tab_cases;
  }

}