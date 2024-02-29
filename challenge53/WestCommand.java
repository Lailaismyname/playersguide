public class WestCommand extends RobotCommand{
	@Override
	public void run(Robot robot){
		if(robot.getPowered()){
			robot.moveX(-1);
		}
	}
}