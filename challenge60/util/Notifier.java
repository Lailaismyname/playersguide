package challenge60.util;
// dit is ook een observer?
public class Notifier implements Observer{
	void handle(){
		System.out.println("A charberry fruit has ripened!");
	}
	@Override
	public void update(){
		handle();
	}
}