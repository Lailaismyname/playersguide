package fountainOfObjects;

class PlayerLocation{
	private int row;
	private int column;
	private int gridSize;
	
	public PlayerLocation(int row, int column, int gridSize){
		this.row = row;
		this.column = column;
		this.gridSize = (gridSize - 1); // subtracting 1 because arr start at 0
	}
	
	
	public void setRow(int newRow){
		if (newRow < 0 || newRow > gridSize){
			throw new IllegalArgumentException("invalid option, min 0 max 3");
		}
		this.row = newRow;
	}
	
	
	public int getRow(){
		return this.row;
	}
	
	
	public void setColumn(int newColumn){
		if (newColumn < 0 || newColumn > gridSize){
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