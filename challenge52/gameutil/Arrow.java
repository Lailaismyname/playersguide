package challenge52.gameutil;

class Arrow{
	int quantity;
	
	public Arrow(int quantity){
		this.quantity = quantity;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public void useArrow(){
		if(quantity != 0){
			quantity--;
		} else {
			throw new IllegalArgumentException("There are no arrows left");
		}
	}
}