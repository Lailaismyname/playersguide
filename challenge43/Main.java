import item.*;

public class Main{
	public static void main(String[] args){
		ColoredItem blueSword = new ColoredItem<>(new Axe(), "blue");
		ColoredItem redBow = new ColoredItem<>(new Sword(), "red");
		ColoredItem greenAxe = new ColoredItem<>(new Bow(), "green");
		
		blueSword.display();
		redBow.display();
		greenAxe.display();
	}
}