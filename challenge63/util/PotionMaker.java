package challenge63.util;
import java.util.Scanner;
import challenge63.util.potionstates.*;
import challenge63.util.Ingredient;
import challenge63.util.Potion;

public class PotionMaker{
	Scanner sc = new Scanner(System.in);
	Potion potion = Potion.WATER;
	Ingredient ingredient = Ingredient.STARDUST;
	PotionState potionState;
	boolean isPotionInProgress;
	
	public PotionMaker(){
		potionState = new Water();
		isPotionInProgress = true;
	}
	
	public void make(){
		do{
			System.out.println("-------");
			printCurrentPotion();
			ingredient = convertToIngredient(getSelection());
			potionState = potionState.mixPotion(ingredient);
			System.out.println("You have created: " + potionState.toString());
			System.out.println("-------");
			if(potionState instanceof RuinedPotion){
				System.out.println("Oh no the potion is ruined, starting over...");
				potionState = new Water();
			}else if(!promptForExtraIngredient()){
				isPotionInProgress = false;
			}
		}while(isPotionInProgress);
	}
	
	public boolean promptForExtraIngredient(){
		System.out.println("Do you want to add another ingredient?");
		String choice;
		do{
			System.out.print("y/n: ");
			choice = sc.nextLine().toLowerCase();
			if(choice.equals("y")){
				return true;
			}else if(choice.equals("n")){
				return false;
			}
		}while(true);
	}
	
	public Potion getCurrentPotion(){
		return potion;
	}
	
	public void printCurrentPotion(){
		String potionName = getCurrentPotion().toString().replace("_", " ").toLowerCase();
		System.out.println("You currently have " + potionName);
	}
	
	
	public String getSelection(){
		System.out.println("You have the following ingredients: ");
		for(Ingredient ingredient: Ingredient.values()){
			String ingredientName = ingredient.toString().replace("_", " ").toLowerCase();
			System.out.println(ingredientName);
		}
		Scanner sc = new Scanner(System.in);
		boolean isValidSelection = false;
		String selection = "";
		do{
			try{
				System.out.print("Enter option: ");
				selection = sc.nextLine();
				if(isIngredient(selection)){
					isValidSelection = true;
				}
			}catch (IllegalArgumentException err){
				System.out.println("Not a valid option");
			}
			
		}while(!isValidSelection);
		return selection;
	}
	
	public boolean isIngredient(String ingredient){
		String reformattedIngredient = ingredient.toUpperCase().replace(" ","_");
		try{
			Ingredient.valueOf(reformattedIngredient);
			return true;
		}catch(IllegalArgumentException err){
			return false;
		}
	}
	
	public Potion convertToPotion(String potion){
		String reformattedPotion = potion.toUpperCase().replace(" ","_");
		return Potion.valueOf(reformattedPotion);
	}
	
	
	public Ingredient convertToIngredient(String ingredient){
		String reformattedIngredient = ingredient.toUpperCase().replace(" ","_");
		return Ingredient.valueOf(reformattedIngredient);
	}
}