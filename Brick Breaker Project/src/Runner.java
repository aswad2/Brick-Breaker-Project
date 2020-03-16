import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Runner extends JFrame
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public Runner()
	{
		super("Brick Breaker");

		setSize(WIDTH,HEIGHT);
		
		//getContentPane().add( new KeyBox() );

		getContentPane().add( new BrickBreaker() );
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		requestFocus();
		setResizable(false);
		setBounds(0, 0, WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
	
		
	}

	public static void main( String args[] )
	{
		Runner run = new Runner();
	}
}