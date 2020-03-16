import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Canvas;

@SuppressWarnings("serial")
public class BouncingBrick extends Brick {
	public static int XSPEED = 1;
	public static int YSPEED = -1;

	public BouncingBrick(int ex, int wy, int wd, int ht) {
		super(ex, wy, wd, ht);
	}

	public void move() {
		x += XSPEED;
		y += YSPEED;
	}
	
	public void resetPos(int ex, int wy) {
		x = ex;
		y = wy;
		XSPEED = 1;
		YSPEED = -1;
	}
	
	public void bounce() {
		YSPEED *= -1;
		XSPEED *= -1;
	}
	

	public void keepInBounds() {
		if (x >= Runner.WIDTH - w  - 10|| x <= 0)
			XSPEED *= -1;
		if (y <= 0)
			YSPEED *= -1;

	}

	@Override
	public void paint(Graphics window) {
		Graphics2D g = (Graphics2D) window;

		Image img1 = Toolkit.getDefaultToolkit().getImage("ball.png");
		window.drawImage(img1, getX(), getY(), 20, 20, this);
	}

}