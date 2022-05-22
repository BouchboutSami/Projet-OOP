import java.util.*;

public class test {
  public static void main(String[] args) {
    // Jeu jeu = new Jeu();
    System.out.println("Bienvenue au jeu de l'anglais");
    System.out.println("Tapez votre pseudo:");
    Scanner scanner = new Scanner(System.in);
    String pseudo = scanner.nextLine();
    Joueur player = new Joueur(pseudo);
    // Partie game = new Partie(player);
    Plateau a = new Plateau();
    a.Afficher_plateau();
  }
}
