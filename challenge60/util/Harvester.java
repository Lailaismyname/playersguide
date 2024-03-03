package challenge60.util;

// observer
public class Harvester implements Observer{
	public void harvest(CharberryTree charberryTree){
		if(charberryTree.isRipe()){
			charberryTree.setRipe(false);
		}
	}
	@Override
	public void update(){
		harvest(new CharberryTree());
	}
}