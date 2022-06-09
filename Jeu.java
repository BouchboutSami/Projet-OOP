
import java.io.*;
import java.util.*;
import java.util.Collection;

public class Jeu implements Serializable {
  public HashMap<String, Joueur> joueurs = new HashMap<String, Joueur>();;
  public static int meilleur_score_global;

  public void gettabjoueur() {
    try {
      FileInputStream fileIn = new FileInputStream("data");
      ObjectInputStream OBF = new ObjectInputStream(fileIn);
      this.joueurs = (HashMap<String, Joueur>) OBF.readObject();
      OBF.close();
      fileIn.close();
      System.out.println("\ndeSerialisation terminée avec succès...\n");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }

  public void settabjoueur() {// serializer le tableau des joueurs dans le fichier binaire
    try {
      FileOutputStream fileOut = new FileOutputStream("data");
      ObjectOutputStream OBF = new ObjectOutputStream(fileOut);
      OBF.writeObject(this.joueurs);
      OBF.close();
      fileOut.close();
      System.out.println("\nSerialisation terminée avec succès...\n");

    } catch (FileNotFoundException e) {

    } catch (IOException e) {

    }
  }

  public Joueur authenticate(String username) {// recuperer un joueur avec son username
    Joueur joueur1;
    gettabjoueur();
    joueur1 = this.joueurs.get(username);
    if (joueur1 == null) {
      System.out.println("new gamer");
      joueur1 = new Joueur(username);
      joueurs.put(username, joueur1);
      settabjoueur();
    }

    return joueur1;
  }

  public void saveEtat(Joueur joueur) {// sauvegarde l'etat des
    joueur.Afficher_infos();
    this.joueurs.put(joueur.getNom_joueur(), joueur);
    settabjoueur();
  }

  public String set_meilleur_score_global() {// permet de recuperer le meilleur score global de tout les joueurs
    List<Integer> intValues = new ArrayList<>();
    for (String name : joueurs.keySet()) {
      intValues.add(joueurs.get(name).getMeilleur_score_personnel());
    }
    Jeu.meilleur_score_global = Collections.max(intValues);
    return Integer.toString(Collections.max(intValues));
  }

}
