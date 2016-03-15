package easy.drive.path;

import ch.aplu.robotsim.*;

public class Path2 {

	public Path2() {

		TurtleRobot robot = new TurtleRobot();
		robot.setTurtleSpeed(100);
		while (true) {
			robot.forward(100);
			robot.right(90);
			robot.forward(100);
			robot.right(90);
			robot.forward(100);
			robot.left(90);
			robot.forward(100);
			robot.left(90);
		}
	}

	public static void main(String[] args) {
		new Path2();

	}

	// ------------------ Environment --------------------------
	static {
		RobotContext.setStartPosition(50, 300);
	}

}
