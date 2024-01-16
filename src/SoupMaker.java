import java.util.Scanner;
public class SoupMaker {
    enum Type {SOUP,STEW,GUMBO}
    enum MainIngredient{MUSHROOMS,CHICKEN,CARROTS,POTATOES}
    enum Seasoning{SPICY,SALTY,SWEET}
    public void makeSoup(){
        Scanner sc = new Scanner(System.in);
        Type userType = null;
        String type;
      do{
          System.out.print("Do you want soup,stew or gumbo? ");
          type = sc.nextLine();
          try{
              userType = Type.valueOf(type.toUpperCase());
          }
          catch(Exception err){
              System.out.println("Not a valid choice.");
          }
      }while(userType == null);
      MainIngredient userIngredient = null;
      String mainIngredient;
      do {
          System.out.print("Do you want Mushroom, chicken, carrots or potatoes as a main ingredient? ");
          mainIngredient = sc.nextLine();
          try{
              userIngredient = MainIngredient.valueOf(mainIngredient.toUpperCase());
          }
          catch(Exception err){
              System.out.println("Not a valid option.");
          }
      }while(userIngredient == null);
      Seasoning userSeasoning = null;
      String seasoning;
      do {
          System.out.print("Do you want spicy, salty or sweet seasoning? ");
          seasoning = sc.nextLine();
          try {
              userSeasoning = Seasoning.valueOf(seasoning.toUpperCase());
          }catch(Exception err){
              System.out.println("Not a valid option.");
          };
      }while(userSeasoning == null);
        // make the class
        Soup userSoup = new Soup(type,mainIngredient,seasoning);
        // run method that shows contents
        userSoup.printSoup();
    }
}

class Soup{
    private String mainIngredient;
    private String seasoning;
    private String type;
    public Soup(String type, String mainIngredient, String seasoning){
        this.type = type;
        this.mainIngredient = mainIngredient;
        this.seasoning = seasoning;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }
    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    public String getSeasoning() {
        return seasoning;
    }

    public void setSeasoning(String seasoning) {
        this.seasoning = seasoning;
    }

    public void printSoup(){
        System.out.println("You made " + this.seasoning + " " + this.mainIngredient + " " + this.type );
    }
}