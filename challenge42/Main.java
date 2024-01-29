public class Main{
	public static void main(String[] args){
		
		Sword sword1 = new Sword(100, SwordMaterial.WOOD, Gemstone.BITSTONE, 10);
		Sword sword2 = new Sword(80, SwordMaterial.IRON,Gemstone.NONE, 50);
		Sword sword3 = new Sword(80, SwordMaterial.STEEL,Gemstone.DIAMOND, 15);
		
		System.out.println(sword1);
		System.out.println(sword2);
		System.out.println(sword3);
	}
}