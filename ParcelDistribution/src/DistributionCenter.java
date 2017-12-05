//add different colors for scanner 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DistributionCenter extends JPanel {
	private static final int frameHeight = 640;
	private static final int frameWidth =  1020;
	private Parcel[] parcels;
	private Scanner scanner = new Scanner();
	private Conveyor conveyor = new Conveyor(scanner);
	
	public DistributionCenter(int n){
		parcels = new Parcel[n];
		for (int i = 0; i < n; i++){
			parcels[i] = new Parcel();
		}
		setFocusable(true);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE){
					conveyor.startStop();
					for (int i = 0; i < parcels.length; i++){
						parcels[i].stopStart(conveyor, scanner);
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
	}
	public static int getFrameHeight(){
		return frameHeight;
	}

	public static int getFrameWidth() {
		return frameWidth;
	}

	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				 RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, frameWidth, frameHeight);
		conveyor.paint(g, scanner);

		for (int i = 0; i < parcels.length; i++){
			parcels[i].paint(g);
		}

		scanner.paint(g); 

	}

	public void move(){
		for (int i = 0; i < parcels.length; i++){
			parcels[i].update(scanner);
		}

		conveyor.update(parcels, scanner);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new  JFrame();
		DistributionCenter panel = new DistributionCenter(20);
		/*panel.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE){
					conveyor.startStop();
					for (int i = 0; i < parcels.length; i++){
						parcels[i].stopStart(conveyor, scanner);
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		
		panel.setFocusable(true);
		*/
		panel.requestFocusInWindow();
		frame.add(panel); 
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		frame.setTitle("Canada Post");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
		//frame.setResizable(false); 
		frame.setLocationRelativeTo(null); //centers the window

		while (true){
			panel.move();
			panel.repaint();
			Thread.sleep(7);
		}
	}


}
