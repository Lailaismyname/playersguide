package challenge63.util.potionstates;
import challenge63.util.Ingredient;
import challenge63.util.Potion;

public class Elixir extends PotionState{
	public PotionState mixPotion(Ingredient ingredient){
		switch(ingredient){
			case Ingredient.SNAKE_VENOM:
				return new PoisonPotion();
			case Ingredient.DRAGON_BREATH:
				return new FlyingPotion();
			case Ingredient.SHADOW_GLASS:
				return new InvisibilityPotion();
			case Ingredient.EYESHINE_GEM:
				return new NightSightPotion();
			default:
				return new RuinedPotion();
		}
	}
	
	
	public Potion getCurrentPotion(){
		return Potion.ELIXIR_POTION;
	}
	
	
	@Override
	public String toString(){
		return "Elixir Potion";
	}
}