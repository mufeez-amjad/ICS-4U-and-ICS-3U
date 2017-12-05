import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements KeyListener{
	
	public static final int lightSize = 40;
	public static final int gameSpeed = 5;
	Intersection inter;
	static Rectangle intersection;

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D a = (Graphics2D) g; 
		a.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		// draw all cars
		for (Car c:Intersection.arrCar)
			c.paint(a);
		
		//draw traffic light
		a.setColor(Intersection.isRed? Color.RED:Color.GREEN);
		a.fillOval((getWidth() - lightSize/2)/2, (getHeight()+lightSize/2)/2, lightSize/2, lightSize/2);
		a.fillOval((getWidth() - lightSize/2)/2, getHeight()/2 - 3*lightSize/4, lightSize/2, lightSize/2);
		a.setColor(Intersection.isRed? Color.GREEN:Color.RED);
		a.fillOval((getWidth()+lightSize/2)/2, (getHeight() - lightSize/2)/2, lightSize/2, lightSize/2);
		a.fillOval(getWidth()/2 - 3*lightSize/4, (getHeight() - lightSize/2)/2, lightSize/2, lightSize/2);
		a.setColor(Color.BLACK);
		a.fillRect((getWidth()-lightSize)/2, (getHeight() - lightSize)/2, lightSize, lightSize);
		a.draw(intersection);
		a.setColor(Color.GREEN);
		a.fillRect(0,0, getWidth()/2 - intersection.width/2-5,getHeight()/2 - intersection.height/2-5);
		a.fillRect(getWidth()/2 + intersection.width/2 -2,0, getWidth()/2 - intersection.width/2,getHeight()/2 - intersection.height/2 - 5);
		a.fillRect(0,getHeight()/2 + intersection.height/2, getWidth()/2 - intersection.width/2-5,getHeight()/2 - intersection.height/2-5);
		a.fillRect(getWidth()/2 + intersection.width/2 -2, getHeight()/2 + intersection.height/2, getWidth()/2 - intersection.width/2, getHeight()/2 - intersection.height/2-5);
	}
	public void init(){
		addKeyListener(this);
		intersection = new Rectangle((getWidth()-lightSize*5)/2, (getHeight() - lightSize*5)/2, lightSize*5, lightSize*5);
		inter = new Intersection(this);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(800, 800);
	}

	public static void main(String[] args)  throws InterruptedException {
		JFrame frame = new JFrame("Intersection Simulation");
		Panel pane = new Panel();
		frame.add(pane);
		pane.setFocusable(true);
        pane.requestFocusInWindow();
		frame.pack();
		pane.init();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		frame.setVisible(true);
		
		while (true){
			pane.inter.move();
			pane.repaint();
			Thread.sleep(gameSpeed);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			Intersection.isRed = !Intersection.isRed;
	}
}
