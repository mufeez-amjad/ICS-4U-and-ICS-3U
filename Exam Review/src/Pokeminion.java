public class Pokeminion {
       private String name;
       private int health;
       private String[] abilities = new String[4];
       private int numAbilities = 0;
      
       public Pokeminion(String n, int h){
              name = n;
              health = h;
       }
      
       public void addAbilty(String a){
              if (numAbilities < 4){
                     abilities[numAbilities] = a;
                     numAbilities++;
              }
       }
      
       public void printAbilities(){
              for (int i = 0; i < numAbilities; i++){
                     System.out.println(abilities[i]);
              }
       }
      
       public String getName(){
              return name;
       }
}