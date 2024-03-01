package challenge56.util;
import java.util.Scanner;
import java.util.Optional;

public class NumberCrunching{
	Scanner sc = new Scanner(System.in);
	
	public Optional<Integer> getIntegerInput(){
		System.out.print("Enter nr: ");
		int nr;
		try{
			nr = Integer.parseInt(sc.nextLine());
			return Optional.of(nr);
		}catch (NumberFormatException err){
			return Optional.empty();
		}
	}
	
	public Optional<Integer> getIntValue(){
		Optional<Integer> nr;
		do{
			nr = getIntegerInput();
		}while (nr.isEmpty());
		return nr;
	}
	
	public Optional<Double> getDoubleInput(){
		System.out.print("Enter double: ");
		double double_nr;
		try{
			double_nr = Double.parseDouble(sc.nextLine());
			return Optional.of(double_nr);
		}catch (NumberFormatException err){
			return Optional.empty();
		}
	}
	
	public Optional<Double> getDoubleValue(){
		Optional<Double> double_nr;
		do{
			double_nr = getDoubleInput();
		}while (double_nr.isEmpty());
		return double_nr;
	}
	
	
	// was hier gebleven, TODO deze mag alleen false returnen als het echt false is
	public Optional<Boolean> getBooleanInput(){
		System.out.print("Enter Boolean: ");
		Boolean bool;
		try{
			bool = Boolean.parseBoolean(sc.nextLine());
			return Optional.of(bool);
		}catch (NumberFormatException err){
			return Optional.empty();
		}
	}
	
	public Optional<Boolean> getBooleanValue(){
		Optional<Boolean> bool;
		do{
			bool = getBooleanInput();
		}while (bool.isEmpty());
		return bool;
	}
	
}