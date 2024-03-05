package challenge63.util.potionstates;
import challenge63.util.Ingredient;
import challenge63.util.Potion;

public abstract class PotionState{
	
	public abstract PotionState mixPotion(Ingredient ingredient);
	
	public abstract Potion getCurrentPotion();

	public abstract String toString();
}