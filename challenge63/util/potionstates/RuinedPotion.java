package challenge63.util.potionstates;
import challenge63.util.Ingredient;
import challenge63.util.Potion;

public class RuinedPotion extends PotionState{
	public PotionState mixPotion(Ingredient ingredient){
		return new Water();
	}
	
	
	public Potion getCurrentPotion(){
		return Potion.RUINED_POTION;
	}
	
	
	@Override
	public String toString(){
		return "Ruined Potion";
	}
}