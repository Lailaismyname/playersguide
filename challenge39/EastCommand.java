public class EastCommand extends RobotCommand{
	@Override
	public void run(Robot robot){
		if(robot.getPowered()){
			robot.moveX(1);
		}
	}
}