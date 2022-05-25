import java.io.*;
import java.util.*;

public class test {
  public static void main(String[] args) throws IOException {
    System.out.println("Bienvenue au jeu de l'anglais");
    System.out.println("Tapez votre pseudo:");
    Scanner scanner = new Scanner(System.in);
    String pseudo = scanner.nextLine();
    Joueur player = new Joueur(pseudo);
    player.partie.getPlateau().getTab_cases()[player.partie.getIndice_actuel()].ActionCase(player.partie);
    player.partie.getPlateau().getTab_cases()[player.partie.getIndice_actuel()].ActionCase(player.partie);
    player.partie.getPlateau().getTab_cases()[player.partie.getIndice_actuel()].ActionCase(player.partie);
    player.partie.getPlateau().getTab_cases()[player.partie.getIndice_actuel()].ActionCase(player.partie);
    player.Afficher_infos();
    scanner.close();
  }
}
