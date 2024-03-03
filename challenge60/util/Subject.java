package challenge60.util;

public interface Subject{
	public void attach(Observer observer);
	public void detach(Observer observer);
	public void notifyObservers(); // blijkbaar is er een Object class in java, die een method heeft die notify heet. En als je dezelfde naam geeft levert dat problemen op. 
}