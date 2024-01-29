public class WestCommand implements RobotCommand{
	public void run(Robot robot){
		if(robot.getPowered()){
			robot.moveX(-1);
		}
	}
}