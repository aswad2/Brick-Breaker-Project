import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Rectangle;

public class Mascot extends Brick {

	public Mascot(int ex, int wy, int wd, int ht) {
		super(ex, wy, wd, ht);
	}
	public void paint(Graphics window) {
		Graphics2D g2 = (Graphics2D) window;
		Image img1 = Toolkit.getDefaultToolkit().getImage("realbrick.png");
		g2.drawImage(img1, x, y, this);
	}

}