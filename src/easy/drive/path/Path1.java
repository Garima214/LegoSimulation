package easy.drive.path;

import ch.aplu.robotsim.TurtleRobot;

public class Path1 {

	public Path1() {

		TurtleRobot robot = new TurtleRobot();
		robot.setTurtleSpeed(100);

		for (int i = 0; i < 4; i++) {
			robot.forward(100);
			robot.right(180);
			robot.forward(100);
			robot.left(90);

		}
		robot.exit();
	}

	public static void main(String[] args) {
		new Path1();

	}

}
