import java.util.Map;

public class Main{
	public static void main(String[] args){
		Coordinate coordinateA = new Coordinate(3,5);
		Coordinate coordinateB = new Coordinate(8,6);
		Coordinate coordinateC = new Coordinate(1,8);
		
		
		System.out.println(isCoordinateAdjacent(coordinateA,coordinateB));
		System.out.println(isCoordinateAdjacent(coordinateB,coordinateC));
	}
	public static boolean isCoordinateAdjacent(Coordinate x, Coordinate y){
		if(x.column() == y.column() || x.row() == y.row()){
			return true;
		}
		else if( (x.column() + 1) == y.column() || (x.row() + 1) == y.row()){
			return true;
		}else{
			return false;
		}
	}
}