package challenge63.util;
import challenge63.util.Ingredient;
import challenge63.util.Potion;
import challenge63.util.potionstates.*;

class WraithPotion extends PotionState{
	public PotionState mixPotion(Ingredient ingredient){
		return new RuinedPotion();
	}
	
	
	public Potion getCurrentPotion(){
		return Potion.WRAITH_POTION;
	}
	
	
	@Override
	public String toString(){
		return "Wraith Potion";
	}
}