package challenge63.util.potionstates;
import challenge63.util.Ingredient;
import challenge63.util.Potion;

public class InvisibilityPotion extends PotionState{
	public PotionState mixPotion(Ingredient ingredient){
		if(ingredient == Ingredient.EYESHINE_GEM){
			return new CloudyBrew();
		}else{
			return new RuinedPotion();
		}
	}
	
	
	public Potion getCurrentPotion(){
		return Potion.INVISIBILITY_POTION;
	}
	
	
	@Override
	public String toString(){
		return "Invisibility Potion";
	}
}