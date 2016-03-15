package light.Sensors;

import ch.aplu.robotsim.*;

public class SearchPath {
	private int path = 0;
	private int v1 = 0;
	private int v2 = 0;

	public SearchPath() {

		LegoRobot robot = new LegoRobot();
		LightSensor sensor1 = new LightSensor(SensorPort.S1);
		LightSensor sensor2 = new LightSensor(SensorPort.S2);

		Gear gear = new Gear();
		robot.addPart(gear);
		robot.addPart(sensor1);
		robot.addPart(sensor2);

		// sensor1.activate(true);
		// sensor2.activate(true);
		gear.setSpeed(80);

		while (!robot.isEnterHit()) {
			v1 = sensor1.getValue();
			v2 = sensor2.getValue();
			if (v1 <= path && v2 <= path)
				gear.forward();
			else {
				gear.stop();

				if (v1 > path) {
					gear.leftArc(0.02, 50);
				} else {
					gear.rightArc(0.02, 50);
				}

				Tools.delay(50);
			}
		}
		robot.exit();
	}

	public static void main(String[] args) {
		new SearchPath();
	}

	static {
		RobotContext.setStartPosition(85, 300);
		RobotContext.setStartDirection(-130);
		RobotContext.useBackground("sprites/roundPath.gif");

	}

}