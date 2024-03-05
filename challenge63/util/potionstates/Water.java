package challenge63.util.potionstates;
import challenge63.util.Ingredient;
import challenge63.util.Potion;

public class Water extends PotionState{
	public PotionState mixPotion(Ingredient ingredient){
		if(ingredient == Ingredient.STARDUST){
			return new Elixir();
		}else{
			return new RuinedPotion();
		}
	}
	
	
	public Potion getCurrentPotion(){
		return Potion.WATER;
	}
	
	
	@Override
	public String toString(){
		return "water";
	}
}