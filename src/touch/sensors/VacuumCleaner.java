package touch.sensors;

import java.awt.Color;
import java.awt.Point;
import ch.aplu.jgamegrid.GGBitmap;
import ch.aplu.robotsim.*;

// Robot moves between the walls

public class VacuumCleaner {

	public VacuumCleaner() {

		TurtleRobot robot = new TurtleRobot();
		TouchSensor sensor = new TouchSensor(SensorPort.S1);
		robot.addPart(sensor);
		robot.setTurtleSpeed(90);
		robot.forward();
		int toggle = 0;
		
		while (!robot.isEnterHit()) {
			if (sensor.isPressed()) {
				if (toggle == 0) {
					robot.backward(30);
					robot.right(90);
					robot.forward(30);
					robot.right(90);
					robot.forward();
					toggle = 1;
				} else {
					robot.backward(30);
					robot.left(90);
					robot.forward(30);
					robot.left(90);
					robot.forward();
					toggle = 0;
				}
			}
		}
		robot.exit();
	}

	public static void main(String[] args) {
		new VacuumCleaner();
	}

	// ------------------ Environment --------------------------
	private static GGBitmap bar(int width, int length, Color color) {
		GGBitmap bm = new GGBitmap(width, length);
		bm.setPaintColor(color);
		bm.fillRectangle(new Point(0, 0), new Point(width - 1, length - 1));
		return bm;
	}

	static {
		RobotContext.setStartPosition(300, 100);
		RobotContext.setStartDirection(0);
		RobotContext.showNavigationBar();
		RobotContext.useObstacle(bar(15, 400, Color.red), 100, 250);
		RobotContext.useObstacle(bar(15, 400, Color.red), 400, 250);

	}

}
