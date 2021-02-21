import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Display extends JPanel {
	public static int fps = 60;
	public static int lifespan = 400;
	public static int popSize = 10000;

	public static int WIDTH = 1200;
	public static int HEIGHT = 800;
    
	// public Target target = new Target((float) (Math.random() * Display.WIDTH), (float) (Math.random() * Display.HEIGHT), 10, 10);
	public Target target = new Target(WIDTH/2, HEIGHT/2, 10, 10);

	// private static long lastUpdate;
    

	private Population population = new Population(popSize, lifespan, target);

	Display() {
		// lastUpdate = System.currentTimeMillis();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); // cleans screen
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		population.run(g2d);

		g2d.fillRect((int) target.x, (int) target.y, target.length, target.height);
		// g2d.fillOval(x, y, 30, 30);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Learning Simulation");
		Display display = new Display();
		frame.add(display);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			display.repaint();
			// Thread.sleep(1000/fps);
			Thread.sleep(1);
		}
	}
}