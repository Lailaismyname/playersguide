public class Arrow{
	public Arrow(String arrowhead, String fletcher, double shaftLength){
		this.arrowhead = arrowhead;
		this.fletcher = fletcher;
		this.shaftLength = shaftLength;
	}

	enum Arrowheads {
		STEEL(10),
		WOOD(3),
		OBSIDIAN(5);
		//constructor
		private Arrowheads(final int price){
			this.price = price;
		}
		//internal state
		private int price;
		
		public int getPrice(){
			return price;
		}
	};
		
	enum Fletchers {
		PLASTIC(10),
		TURKEY_FEATHERS(5), 
		GOOSE_FEATHERS(3);
		//constructor
		private Fletchers(final int price){
			this.price = price;
		}
		//internal state
		private int price;
		
		public int getPrice(){
			return price;
		}
	};
	
	Arrowheads selectedArrowhead;
	Fletchers selectedFletcher;
	
	String arrowhead;
	String fletcher;
	double shaftLength;

	public float getCost(){
		selectedArrowhead = convertToArrowhead(arrowhead);
		selectedFletcher = convertToFletcher(fletcher);
		double total = (double)selectedArrowhead.getPrice() + (double)selectedFletcher.getPrice() + (shaftLength * 0.05);
		return (float) total;
	}
	// method to convert to enum
	private Arrowheads convertToArrowhead(String choice){
		switch(choice){
			case "STEEL":
				return Arrowheads.STEEL;
			case "WOOD":
				return Arrowheads.WOOD;
			case "OBSIDIAN": 
				return Arrowheads.OBSIDIAN;
			default: 
				throw new IllegalArgumentException("Invalid arrowhead selection");
		}
	}
	// and anotha one
	private Fletchers convertToFletcher(String fletcherChoice){
		switch(fletcherChoice){
			case "PLASTIC":
				return Fletchers.PLASTIC;
			case "TURKEY_FEATHERS":
				return Fletchers.TURKEY_FEATHERS;
			case "GOOSE_FEATHERS": 
				return Fletchers.GOOSE_FEATHERS;
			default: 
				throw new IllegalArgumentException("Invalid fletcher selection");
		}
	}

}