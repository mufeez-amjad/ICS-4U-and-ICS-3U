import java.io.File;
import java.io.IOException;
import java.util.Scanner;
 
public class Miniondex {
       private Pokeminion[] pokemons;
      
       public void readFile(){
              try{
                     Scanner sc = new Scanner(new File("src/text.txt"));
                     int num = sc.nextInt();
                     pokemons = new Pokeminion[num];
                     int i = 0;
                     while (i < num && sc.hasNextLine()){
                           int j = 0;
                           String name = "";
                           int health = 0;
                           while (j < 6 && sc.hasNextLine()){
                                  if (j == 0){
                                         name = sc.next();
                                  }
                                  else if (j == 1){
                                         health = sc.nextInt();
                                         sc.nextLine();
                                         pokemons[i] = new Pokeminion(name, health);
                                  }
                                  else if (j < 6){
                                         pokemons[i].addAbilty(sc.nextLine());
                                  }
                                  j++;
                           }
                           i++;
                     }
                     sc.close();
              }
              catch (IOException e){
                     System.out.println("text.txt is not formatted correctly");
              }
       }
      
       public void printNames(){
              for (int i = 0; i < pokemons.length; i++){
                     System.out.println(pokemons[i].getName());
              }
       }
      
       public void printList(){
              for (int i = 0; i < pokemons.length; i++){
                     System.out.println(pokemons[i].getName());
                     pokemons[i].printAbilities();
                     System.out.println();
              }
       }
      
       public static void main(String[] args){
              Miniondex index = new Miniondex();
              index.readFile();
              if (index.pokemons != null) index.printList();
       }
}