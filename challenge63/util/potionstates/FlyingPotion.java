package challenge63.util.potionstates;
import challenge63.util.Ingredient;
import challenge63.util.Potion;

class FlyingPotion extends PotionState{
	public PotionState mixPotion(Ingredient ingredient){
		return new RuinedPotion();
	}
	
	
	public Potion getCurrentPotion(){
		return Potion.FLYING_POTION;
	}
	
	
	@Override
	public String toString(){
		return "Flying Potion";
	}
} 