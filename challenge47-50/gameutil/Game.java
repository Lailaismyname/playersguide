package gameutil;
// import helperclasses.TerminalColor; 			// ff uitvogelen hoe die classpath werkt

public class Game{
	//  main game loop
	Menu menu = new Menu();
	PlayerCommand command = new PlayerCommand();
	// colors 
	/*
	teaRose = 			rgb(239,199,194)
	champagnePink =		rgb(255,229,212)
	ashGrey = 			rgb(191,211,193)
	CambridgeBlue = 	rgb(104,166,145)
	eggPlant = 			rgb(105,79,93)
	*/
	
	TerminalColor teaRose = new TerminalColor(239,199,194);
	TerminalColor champagnePink = new TerminalColor(255,229,212);
	TerminalColor ashGrey = new TerminalColor(191,211,193);
	TerminalColor CambridgeBlue = new TerminalColor(104,166,145);
	TerminalColor eggPlant = new TerminalColor(105,79,93);
	
	public void play(){
		// when the game starts ask for game size:
		int size = menu.getGameSize();
		// print introductory text
		menu.printIntroTxt();
		// set the rooms on the map
		Map worldmap = new Map(size);
		worldmap.setMap();
		System.out.println(command.getPlayerMove());
		//
		
	}
	
}