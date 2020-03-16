import java.awt.*;

@SuppressWarnings("serial")
public class SlidingMascot extends Brick {
	private int speed;

	public SlidingMascot(int ex, int wy, int wd, int ht, int sp) {
		super(ex, wy, wd, ht);
		speed = sp;
	}

	public void upX() {
		setX(getX() + speed);
	}

	public void downX() {
		setX(getX() - speed);
	}

	public void keepInBounds() {
		if (getX() > Runner.WIDTH + w)
			setX(0 - w);
		if (getX() < 0 - w )
			setX(Runner.WIDTH + w);
	}
	
	public void resetPos(int ex, int wy) {
		x = ex;
		y = wy;
	}

	@Override
	public void paint(Graphics window) {
		Graphics2D g2 = (Graphics2D) window;
		
		Image slider = Toolkit.getDefaultToolkit().getImage("slidingpaddle.png");
		g2.drawImage(slider, getX(), getY(), this);
	}
}