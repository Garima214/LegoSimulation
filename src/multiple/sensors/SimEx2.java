package multiple.sensors;

import java.awt.Color;
import java.awt.Point;

import ch.aplu.jgamegrid.GGBitmap;
import ch.aplu.robotsim.*;

// 2 Light Sensors, 1 touch sensor
//Follow the white path
//When the robot hits the RED wall, it turns around by 180 degree, and continues
//on the path

public class SimEx2 {

	private int path = 1000;

	public SimEx2() {
		LegoRobot robot = new LegoRobot();
		LightSensor lSesnor1 = new LightSensor(SensorPort.S1);
		LightSensor lSesnor2 = new LightSensor(SensorPort.S3);
		TouchSensor tSensor = new TouchSensor(SensorPort.S1);
		Gear gear = new Gear();
		int v1, v2;

		robot.addPart(gear);
		robot.addPart(tSensor);
		robot.addPart(lSesnor1);
		robot.addPart(lSesnor2);

		gear.setSpeed(60);

		while (true) {
			if (!tSensor.isPressed()) {
				v1 = lSesnor1.getValue() + 2;
				v2 = lSesnor2.getValue() + 2;
				if (v1 >= path && v2 >= path)
					gear.forward();
				else {
					gear.stop();

					if (v1 < path) {
						gear.leftArc(0.02, 50);
					} else {
						gear.rightArc(0.02, 50);
					}

					Tools.delay(50);
				}
			} else {
				gear.stop();
				gear.leftArc(0, 850);
				Tools.delay(1000);
			}

		}
	}

	public static void main(String[] args) {
		new SimEx2();

	}

	// ------------------ Environment --------------------------

	private static GGBitmap bar(int width, int length, Color color) {
		GGBitmap bm = new GGBitmap(width, length);
		bm.setPaintColor(color);
		bm.fillRectangle(new Point(0, 0), new Point(width - 1, length - 1));
		return bm;
	}

	static {
		RobotContext.setStartPosition(80, 400);
		RobotContext.setStartDirection(-90);
		RobotContext.useBackground("sprites/track.png");
		RobotContext.useObstacle(bar(100, 20, Color.red), 80, 450);
		RobotContext.useObstacle(bar(20, 100, Color.red), 440, 90);
	}

}
