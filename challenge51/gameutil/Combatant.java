package challenge51.gameutil;

class Combatant{
	private int maxHealth;
	private int currentHealth;
	
	public Combatant(int maxHealth){
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
	}
	
	public void takeOfDamage(int damage){
		currentHealth -= damage;
	}
	
	public int getHealth(){
		return currentHealth;
	}
	
	
	@Override
	public String toString(){
		return currentHealth + "/" + maxHealth;
	}
}