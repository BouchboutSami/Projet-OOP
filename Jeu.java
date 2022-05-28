

import java.io.*;
import java.util.*;
import java.util.Collection;

public class Jeu implements Serializable {
 public HashMap<String, Joueur> joueurs = new HashMap<String, Joueur>();;


public void gettabjoueur() {
    try {
        FileInputStream fileIn = new FileInputStream("data");
        ObjectInputStream OBF = new ObjectInputStream(fileIn);
        this.joueurs = (HashMap<String, Joueur> ) OBF.readObject();
        OBF.close();
        fileIn.close();
        System.out.println("\ndeSerialisation terminée avec succès...\n");
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
         e.printStackTrace();
      }


}    
public void  settabjoueur(){
    try {
        FileOutputStream fileOut = new FileOutputStream("data");
        ObjectOutputStream OBF = new ObjectOutputStream(fileOut);
        OBF.writeObject(this.joueurs);
        OBF.close();
        fileOut.close();
        System.out.println("\nSerialisation terminée avec succès...\n");
  
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
}
public Joueur authenticate(String username){
     Joueur joueur1 ;
    gettabjoueur();
    joueur1 = this.joueurs.get(username); 
    if( joueur1 == null ){
        
        joueur1 = new Joueur(username);
        joueurs.put(username, joueur1);
        settabjoueur();
    }
    
    
    return joueur1;
}
public Joueur first_time_authenticate(String username){
    Joueur joueur1 ;
    gettabjoueur();
    joueur1 = this.joueurs.get(username); 
    if( joueur1 == null ){
        
        
        joueur1 = new Joueur(username);
        joueurs.put(username, joueur1);
        settabjoueur();
        
        
        if(joueur1 != null){
            System.out.println("player is created succesfuly ");
        }
        return joueur1;
       
    }
    else{
      authenticate(username);
      return joueur1;
    
}


}
}