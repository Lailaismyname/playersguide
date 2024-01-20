public class Main{
	public static void main(String[] args){
		Point point0 = new Point();
		System.out.println(point0.toString());
		Point point1 = new Point(2,3);
		System.out.println(point1.toString());
		Point point2 = new Point(-4,0);
		System.out.println(point2.toString());
		/* Are x and y immutable?
			No because you can still use setter to overwrite them, making the variable private just makes it harder to overwrite not impossible. 
			*/
		}
}