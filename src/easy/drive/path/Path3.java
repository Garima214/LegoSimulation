package easy.drive.path;

import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.RobotContext;

public class Path3 {

	public Path3() {

		LegoRobot robot = new LegoRobot();
		Gear gear = new Gear();
		robot.addPart(gear);

		gear.setSpeed(80);

		while (!robot.isEnterHit()) {
			gear.rightArc(0.25, 4000);
			gear.rightArc(0.05, 900);
		}
		robot.exit();
	}

	public static void main(String[] args) {
		new Path3();
	}

	// ------------------ Environment --------------------------
	static {
		RobotContext.setStartPosition(50, 250);
	}

}
