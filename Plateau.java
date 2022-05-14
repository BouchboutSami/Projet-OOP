
/**
 * Plateau
 */
import java.util.Arrays;

public class Plateau {
  private final int nb_cases = 100;
  private Case[] tab_cases = new Case[nb_cases];

  /**
   * 
   */
  public Plateau() {
    Case[] tab_generator = new Case[] { new CaseSaut(), new CaseMalus(), new CaseBonus(), new CaseImage(),
        new CaseDefinition() };
    tab_cases[0] = new CaseDepart();
    tab_cases[99] = new CaseFin();
    for (int j = 0; j < tab_generator.length; j++) {
      for (int i = 0; i < 5; i++) {
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

  public void Afficher_tab() {
    for (Case case1 : tab_cases) {
      System.out.println(case1);
    }
  }
}