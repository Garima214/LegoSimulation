package light.Sensors;

import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.LightSensor;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;

public class LightAndDark {

	public LightAndDark() {

		LegoRobot robot = new LegoRobot();
		Gear gear = new Gear();
		LightSensor lSensor = new LightSensor(SensorPort.S1);
		robot.addPart(gear);
		robot.addPart(lSensor);
		lSensor.activate(true);

		while (!robot.isEnterHit()) {
			gear.forward();
			int v = lSensor.getValue();

			if (v == 0) {
				gear.stop();
				gear.leftArc(0.05, 1350);

			}
		}

		robot.exit();
	}

	public static void main(String[] args) {
		new LightAndDark();

	}

	// ------------------ Environment --------------------------
	static {

		RobotContext.setStartPosition(150, 280);
		RobotContext.setStartDirection(0);
		RobotContext.useBackground("sprites/blackPanels.gif");

	}

}
