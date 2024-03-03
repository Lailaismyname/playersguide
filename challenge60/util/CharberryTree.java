package challenge60.util;
import java.util.Random;
import java.util.ArrayList;


// dit is de subject
public class CharberryTree implements Subject{
    private Random random = new Random();
    private boolean ripe = false;
	// keep track of the observers
	private ArrayList<Observer> observers;
	
	public CharberryTree(){
		observers = new ArrayList<>();
	}
    
    public void maybeGrow() {
    
        // Only a tiny chance of ripening each time, but we try a lot!
        if (random.nextDouble() < 0.00000001 && !ripe){
            ripe = true;
			notifyObservers();
		}
   }
   
   @Override
   public void attach(Observer observer){
	   observers.add(observer);
   }
   
   
   @Override
   public void detach(Observer observer){
	   observers.remove(observer);
   }
   
   
   @Override
   public void notifyObservers(){
	   for(Observer viewer : observers){
		   viewer.update();
	   }
   }
   
   public boolean isRipe(){
	   return ripe;
   }
   
   public void setRipe(boolean newStatus){
	   ripe = newStatus;
   }
}