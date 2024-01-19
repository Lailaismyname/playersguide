public class Main{
	public static void main(String[] args){
		countdown(10);
	}
	static void countdown(int nr){
		System.out.println(nr);
		if(nr > 1){
			countdown(nr-1);
		}else{
			return;
		}
	}
}