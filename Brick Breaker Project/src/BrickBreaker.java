import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.awt.MouseInfo;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class BrickBreaker extends JPanel implements Runnable, KeyListener {
	private boolean[] keys;

	private Brick bob;
	private SlidingMascot pad;
	private List<Mascot> bricks;
	private BouncingBrick ball;
	private boolean start = false;
	private int bricksremaining = 25;
	private int origbricks = bricksremaining;
	private int lives = 3;
	private int score = 0;

	public BrickBreaker() {
		setBackground(Color.WHITE);
		keys = new boolean[3];
		pad = new SlidingMascot(360, 530, 85, 35, 2);
		bricks = generateBricks();
		ball = new BouncingBrick(600, 493, 15, 15);
		addKeyListener(this);
		this.setFocusable(true);
		Thread t = new Thread(this);
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
	}

	public ArrayList<Mascot> generateBricks() {
		ArrayList<Mascot> bricks = new ArrayList<Mascot>();
		int numBricks = 25;
		for (int i = 0; i < numBricks; i++) {
			int x = (int) (Math.random() * 16) + 1;
			int y = (int) (Math.random() * 12) + 1;
			bricks.add(new Mascot(x * 47, y * 27, 40, 25));
		}

		return bricks;
	}

	public void paint(Graphics window) {
		window.setColor(Color.BLUE);
		window.fillRect(0, 0, 800, 600);
		window.setColor(Color.WHITE);

		if (keys[1]) {
			pad.downX();
		}
		if (keys[2]) {
			pad.upX();
		}
		ball.move();
		pad.keepInBounds();
		ball.keepInBounds();
		if (ball.intersects(pad)) {
			ball.bounce();
			
		}

		ball.paint(window);
		pad.paint(window);

		Iterator<Mascot> rad = bricks.iterator();
		while (rad.hasNext()) {
			Mascot cur = rad.next();
			if (ball.intersects(cur)) {
				ball.bounce();
				rad.remove();
				bricksremaining--;
				score += 1;
			}
			cur.paint(window);
		}

		window.drawString("Bricks Remaining: " + bricksremaining, 676, 550);
		window.drawString("Lives: " + lives, 750, 565);
	}

	public void keyTyped(KeyEvent e) {
		keyPressed(e);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[0] = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[1] = true;
			

		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[2] = true;
			
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[0] = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[1] = false;

		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[2] = false;
		}
	}

	public boolean init() {
		if (keys[0] == true) {
			start = true;
		}
		return start;
	}

	public void run() {
		try {
			while (true) {
				if (true) {
					  if (ball.y >= Runner.HEIGHT) {
						lives--;
						if (lives == 0) {
						JOptionPane.showMessageDialog(this, "Final Score: " + score + " out of "  + origbricks + " bricks.", "OUT OF LIVES", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
						else if (lives == 1) {
							JOptionPane.showMessageDialog(this, "You have " + (lives) + " life remaining", "YOU DIED",
									JOptionPane.INFORMATION_MESSAGE);
						ball.resetPos(400 - 15, 493);
						pad.resetPos(400 - 40, 543);
						keys[0] = false;
						keys[1] = false;
						keys[2] = false;
						}
						else {
						JOptionPane.showMessageDialog(this, "You have " + (lives) + " lives remaining", "YOU DIED",
								JOptionPane.INFORMATION_MESSAGE);
						ball.resetPos(400 - 15, 493);
						pad.resetPos(400 - 40, 543);
						keys[0] = false;
						keys[1] = false;
						keys[2] = false;
						}

					}
					if (bricks.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Congratulations!", "YOU WIN",
								JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}

					Thread.sleep(3);
					repaint();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

	}
}