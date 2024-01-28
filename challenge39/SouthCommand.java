public class SouthCommand extends RobotCommand{
	@Override
	public void run(Robot robot){
		if(robot.getPowered()){
			robot.moveY(-1);
		}
	}
}