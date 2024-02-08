package fountainOfObjects;

class PlayerLocation{
	private int row;
	private int column;
	
	public PlayerLocation(int row, int column){
		this.row = row;
		this.column = column;
	}
	// is het bad practice of dit soort dingen aan setters toe te voegen?
	public void setRow(int newRow){
		if (newRow < 0 || newRow > 3){
			throw new IllegalArgumentException("invalid option, min 0 max 3");
		}
		this.row = newRow;
	}
	
	public int getRow(){
		return this.row;
	}
	
	public void setColumn(int newColumn){
		if (newColumn < 0 || newColumn > 3){
			throw new IllegalArgumentException("Invalid option, min 0 max 3");
		}
		this.column = newColumn;
	}
	public int getColumn(){
		return this.column;
	}
	
	@Override 
	public String toString(){
		return "row: " + this.row + " column: " + this.column;
	}
}