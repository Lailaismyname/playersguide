record Sword(int length, SwordMaterial swordMaterial, Gemstone gemstone, int crossguardWidth) { 
	public String toString(){
		return "a " + this.swordMaterial + " sword of " + this.length + " centimetres long, a width of " + crossguardWidth + " cm, and an " + this.gemstone;
	}
}