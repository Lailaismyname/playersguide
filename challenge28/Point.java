public class Point{
	// variabelen
	private int x;
	private int y;
	// constructors
	public Point(){
		this.x = 0;
		this.y = 0;
	};
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	// methods
	public String toString(){
		return "X: " + x + ",Y: " + y; 
	}
	
	// getters
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}