package touch.sensors;

import java.awt.Color;
import java.awt.Point;

import ch.aplu.jgamegrid.GGBitmap;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.RobotContext;

//Create background for a course

public class CreateObstacles {

	public CreateObstacles() {
		LegoRobot robot = new LegoRobot();
	}

	public static void main(String[] args) {
		new CreateObstacles();

	}

	// ------------------ Environment --------------------------
	private static GGBitmap bar(int width, int length, Color color) {
		GGBitmap bm = new GGBitmap(width, length);
		bm.setPaintColor(color);
		bm.fillRectangle(new Point(0, 0), new Point(width - 1, length - 1));
		return bm;
	}

	private static GGBitmap circle(int radius, Color color) {
		GGBitmap bm = new GGBitmap(2 * radius, 2 * radius);
		bm.setPaintColor(color);
		bm.setLineWidth(3);
		bm.drawCircle(new Point(radius, radius), radius - 1);
		return bm;
	}

	static {
		RobotContext.setStartPosition(300, 200);
		RobotContext.setStartDirection(30);
		RobotContext.showNavigationBar();
		RobotContext.useObstacle(bar(350, 10, Color.red), 250, 100);
		RobotContext.useObstacle(bar(350, 10, Color.red), 250, 400);
		RobotContext.useObstacle(bar(10, 300, Color.red), 80, 250);
		RobotContext.useObstacle(bar(10, 300, Color.red), 420, 250);
		RobotContext.useObstacle(bar(70, 100, Color.green), 250, 345);
		RobotContext.useObstacle(bar(20, 150, Color.blue), 350, 180);
		RobotContext.useObstacle(bar(150, 15, Color.blue), 160, 200);

	}

}
