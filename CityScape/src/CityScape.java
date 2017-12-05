import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

public class CityScape extends JPanel {
	private final static int frameHeight = 900;
	private final static int frameWidth =  1200;
	
	private static ArrayList<UFO> ufos = new ArrayList<UFO>();
	private ArrayList<Building> buildings = new ArrayList<Building>();
	private static Car car = new Car();
	private static PlayerUFO player = new PlayerUFO();

	
	public CityScape(int nUFO){

		buildings.add(new Building(30, 700, 5, 25));
		buildings.add(new Building(200, 700, 3, 10));
		buildings.add(new Building(350, 700, 10, 15));
		buildings.add(new Building(650, 700, 5, 20));
		buildings.add(new Building(790, 700, 5, 23));
		buildings.add(new Building(975, 700, 7, 13));

		for (int i = 0; i < nUFO; i++){
			ufos.add(new UFO());
		}
	}

	public static int getFrameHeight(){
		return frameHeight;
	}
	
	public static int getFrameWidth(){
		return frameWidth;
	}
	
	public void move(){
		for (UFO u : ufos) {
			u.update();	
		}
		
		for (int i = 0; i < ufos.size(); i++)
			 for (int j = i+1; j<ufos.size(); j++)
			 ufos.get(i).collision(ufos.get(j));
		
		if (car != null){
			car.move();
			if (car.getY() < player.getY() && player.ifTarget()) car  = null;
		}
		
		
	}
	
	public static void makeUFOs(int n){
		for (int i = 0; i < n; i++){
			ufos.add(new UFO());
		}
	}

	public static void clearUFOs(int n){
		ufos.clear();
	}

	public void paint(Graphics g){

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, frameWidth, frameHeight);

		for (Building b : buildings) {
			b.paint(g);
		}

		g.setColor(Color.WHITE);
		g.fillOval(20, 20, 50, 50);

		for (UFO u : ufos) {
			u.paint(g);
		}
		if (car != null) car.paint(g);
		player.paint(g);

	}

	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new  JFrame();
		CityScape panel = new CityScape(3);
		panel.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_SPACE){
					player.beam(false);
				} 
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_SPACE){
					player.beam(true);
					if (car != null) player.suckUp(car);
				} 
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					ufos.add(new UFO());
				}

				if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
					ufos.clear(); 
				} 

				if(e.getKeyCode()==KeyEvent.VK_UP){
					player.move(0, -1);
				} 

				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					player.move(0, 1);
				} 

				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					player.move(-1, 0);
				} 

				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					player.move(1, 0);
				} 

			}
		});

		panel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e){
				System.out.println("MOVED");
			}
		});
		frame.add(panel);	
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		frame.setVisible(true);
		frame.setTitle("City Scape");
		frame.setSize(frameWidth, frameHeight);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
		//frame.setResizable(false); 
		frame.setLocationRelativeTo(null); //centers the window

		while (true){
			panel.move();
			panel.repaint();
			Thread.sleep(5);
		}
	}

}