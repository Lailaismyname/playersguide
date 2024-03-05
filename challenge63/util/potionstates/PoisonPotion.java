package challenge63.util.potionstates;
import challenge63.util.Ingredient;
import challenge63.util.Potion;

class PoisonPotion extends PotionState{
	public PotionState mixPotion(Ingredient ingredient){
		return new RuinedPotion();
	}
	
	
	public Potion getCurrentPotion(){
		return Potion.POISON_POTION;
	}
	
	
	@Override
	public String toString(){
		return "Poison Potion";
	}
}