public class InventoryItem{
	double weight;
	double volume;
	String name;
	// constructors
	public InventoryItem(){};
	// methods
	public double getWeight(){
		return this.weight;
	}
	public double getVolume(){
		return this.volume;
	}
	public String getName(){
		return this.name;
	}
	@Override
	public String toString(){
		return this.name;
	}
}
