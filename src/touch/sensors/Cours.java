package touch.sensors;

import ch.aplu.robotsim.*;

//Two Touch Sensors
//Travel through the course

public class Cours {

	public Cours() {

		TurtleRobot robot = new TurtleRobot();
		TouchSensor sensor1 = new TouchSensor(SensorPort.S1);
		TouchSensor sensor2 = new TouchSensor(SensorPort.S2);
		robot.addPart(sensor1);
		robot.addPart(sensor2);
		robot.setTurtleSpeed(100);
		robot.forward();

		while (true) {
			if (sensor1.isPressed()) {
				robot.backward(10);
				robot.left(60);
				robot.forward();

			} else if (sensor2.isPressed()) {
				robot.backward(10);
				robot.right(80);
				robot.forward();

			}
		}
	}

	public static void main(String[] args) {
		new Cours();
	}

	// ------------------ Environment --------------------------

	static {
		RobotContext.setStartPosition(320, 460);
		RobotContext.setStartDirection(-100);
		RobotContext.showNavigationBar();
		RobotContext.useObstacle("sprites/parcours.gif", 250, 250);
	}
}
