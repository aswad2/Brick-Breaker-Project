import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

public abstract class Brick extends Canvas {
	public int x, y, w, h;
	
	public Brick(int ex, int wy, int wd, int ht) {
		x = ex;
		y = wy;
		w = wd;
		h = ht;
	}

	public abstract void paint(Graphics window);

	public boolean intersects(Object o) {
		Brick obj = (Brick) o;
		Rectangle brick = new Rectangle(x, y, w, h);
		Rectangle temp = new Rectangle(obj.x, obj.y, obj.w , obj.h );
		return brick.intersects(temp);
	}

	public int getX() {
		return x;
	}

	public void setX(int ex) {
		x = ex;
	}

	public int getY() {
		return y;
	}

	public void setY(int wy) {
		y = wy;
	}
}