package light.Sensors;

import ch.aplu.robotsim.*;

//YELLOW = 1000
//GREEN = 600
//BLUE = 686
//BLACK = 3

public class RaceCourse1 implements LightListener {

	private int count = 0;
	private int yellowPath = 1000;
	private int greenPath = 600;
	private int triggerLevel = 100;

	public void bright(SensorPort arg0, int arg1) {

	}

	public void dark(SensorPort port, int arg1) {
		count++;
		System.out.println("COUNT = " + count);

	}

	public RaceCourse1() {
		LegoRobot robot = new LegoRobot();
		LightSensor sensor1 = new LightSensor(SensorPort.S1);
		LightSensor sensor2 = new LightSensor(SensorPort.S2);

		Gear gear = new Gear();
		robot.addPart(gear);
		robot.addPart(sensor1);
		robot.addPart(sensor2);
		sensor1.addLightListener(this, triggerLevel);
		int v1, v2;

		gear.setSpeed(80);
		while (count < 3) {
			v1 = sensor1.getValue();
			v2 = sensor2.getValue();
			if (v1 == yellowPath && v2 == yellowPath) {
				gear.forward();
			} else if (v1 == 3 && v2 == 3) {
				gear.forward();
			} else {
				gear.stop();
				if (v1 == greenPath) {
					gear.leftArc(0.15);

				} else {
					gear.rightArc(0.15);

				}
			}

		}
		robot.exit();
	}

	public static void main(String[] args) {
		new RaceCourse1();

	}

	// ------------------ Environment --------------------------
	static {

		RobotContext.setStartPosition(430, 260);
		RobotContext.setStartDirection(90);
		RobotContext.useBackground("sprites/yellowpath.gif");
		RobotContext.showStatusBar(20);
	}

}
