package challenge63.util.potionstates;
import challenge63.util.Ingredient;
import challenge63.util.Potion;

class CloudyBrew extends PotionState{
	public PotionState mixPotion(Ingredient ingredient){
		if(ingredient == Ingredient.STARDUST){
			return new WraithPotion();
		}else{
			return new RuinedPotion();
		}
	}
	
	
	public Potion getCurrentPotion(){
		return Potion.CLOUDY_BREW;
	}
	
	
	@Override
	public String toString(){
		return "Cloudy Brew";
	}
}