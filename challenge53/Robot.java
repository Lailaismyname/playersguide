import java.util.List;

public class Robot {
    private int x;

    private int y;

    private boolean isPowered;

    public void moveX(int step) {
        if (isPowered) x += step;
    }

    public void moveY(int step) {
        if (isPowered) y += step;
    }

    private final RobotCommand[] commands = new RobotCommand[3];

    public Robot(List<RobotCommand> inputCommands) {
        if (inputCommands.size() != 3) throw new IllegalArgumentException("Error: Need three commands.");
        inputCommands.toArray(commands);
    }

    public void setPowered(boolean powered) {
        isPowered = powered;
    }
	public boolean getPowered(){
		return isPowered;
	}

    public void run() {
        for (RobotCommand command : commands) {
            command.run(this);
            System.out.printf("[%d %d %b]\n", x, y, isPowered);
        }
    }
}