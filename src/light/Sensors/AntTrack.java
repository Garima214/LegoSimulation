package light.Sensors;

import ch.aplu.robotsim.*;

public class AntTrack {

	private int path = 1000;
	private int v1 = 0;
	private int v2 = 0;

	public AntTrack() {

		LegoRobot robot = new LegoRobot();
		Gear gear = new Gear();
		LightSensor sensor1 = new LightSensor(SensorPort.S1);
		LightSensor sensor2 = new LightSensor(SensorPort.S2);

		robot.addPart(gear);
		robot.addPart(sensor1);
		robot.addPart(sensor2);
		
		
		while (true) {
			v1 = sensor1.getValue();
			v2 = sensor2.getValue();

			if (v1 >= path && v2 >= path) {
				gear.forward();
			} else {
				gear.stop();
				if (v2 < path) {
					System.out.println("RIGHT");					
					gear.rightArc(0.25);
					Tools.delay(500);
					
				} else {
					System.out.println("LEFT");
					gear.leftArc(0.25);
					Tools.delay(500);
				}	
			}
		}
	}

	public static void main(String[] args) {
		new AntTrack();

	}

	// ------------------ Environment --------------------------
	static {
		RobotContext.setStartPosition(50, 75);
		RobotContext.setStartDirection(0);
		RobotContext.useBackground("sprites/antPath.gif");
		RobotContext.showStatusBar(20);
	}

}
