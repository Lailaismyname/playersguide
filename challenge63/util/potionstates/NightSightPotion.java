package challenge63.util.potionstates;
import challenge63.util.Ingredient;
import challenge63.util.Potion;

class NightSightPotion extends PotionState{
	public PotionState mixPotion(Ingredient ingredient){
		if(ingredient == Ingredient.SHADOW_GLASS){
			return new CloudyBrew();
		}else{
			return new RuinedPotion();
		}
	}
	
	
	public Potion getCurrentPotion(){
		return Potion.NIGHT_SIGHT_POTION;
	}
	
	
	@Override
	public String toString(){
		return "Night Sight Potion";
	}
}