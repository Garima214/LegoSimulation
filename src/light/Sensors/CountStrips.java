package light.Sensors;

import ch.aplu.robotsim.*;

public class CountStrips implements LightListener {

	private int stripCount = 0;
	private int triggerLevel = 100;

	public CountStrips() {

		LegoRobot robot = new LegoRobot();
		Gear gear = new Gear();
		LightSensor lSensor = new LightSensor(SensorPort.S1);
		lSensor.addLightListener(this, triggerLevel);

		robot.addPart(gear);
		robot.addPart(lSensor);

		while (!robot.isEnterHit()) {
			gear.forward();
		}
		robot.exit();
	}

	public void bright(SensorPort port, int level) {
		// TODO Auto-generated method stub

	}

	public void dark(SensorPort port, int level) {
		stripCount++;
		System.out.println("Strip Count = " + stripCount);

	}

	public static void main(String[] args) {
		new CountStrips();

	}

	// ------------------ Environment --------------------------
	static {

		RobotContext.setStartPosition(50, 300);
		RobotContext.setStartDirection(0);
		RobotContext.useBackground("sprites/panel.gif");
		 RobotContext.showStatusBar(20);
	}

}
