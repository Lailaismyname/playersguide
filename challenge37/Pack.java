import java.util.ArrayList;
public class Pack{
	// variables
	ArrayList<InventoryItem> items =  new ArrayList<InventoryItem>();
	private double maxWeight;
	private double currentWeight;
	private double maxVolume;
	private double currentVolume;
	private int packItemsAmount;
	
	// constructors
	public Pack(){
		
	}
	public Pack(double maxWeight, double maxVolume){
		this.maxWeight = maxWeight;
		this.maxVolume = maxVolume;
	}
	// methods
	public boolean addInventoryItem(InventoryItem item){
		if((currentWeight + item.getWeight()) >= maxWeight){
			System.out.println("Couldn't add item, weight is maxed out");
			return false;
		}else if((currentVolume + item.getVolume()) >= maxVolume){
			System.out.println("Couldn't add item, volume is maxed out.");
			return false;
		}else{
			items.add(item);
			currentWeight = currentWeight + item.getWeight();
			currentVolume = currentVolume + item.getVolume();
			packItemsAmount++;
			return true;
		}
	}
	
	public ArrayList<InventoryItem> getPackItems(){
		return items;
	}
	
	
	public double getMaxWeight(){
		return this.maxWeight;
	}
	
	
	public double getMaxVolume(){
		return this.maxVolume;
	}
	
	
	public double getCurrentWeight(){
		return this.currentWeight;
	}
	
	
	public double getCurrentVolume(){
		return this.currentVolume;
	}
	
	
	public double getPackItemsAmount(){
		return this.packItemsAmount;
	}
}

// elke pack heeft een limiet mbt aantal items erin, het max gewicht en de volume
