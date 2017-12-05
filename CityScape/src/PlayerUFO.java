import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerUFO {
	private int x;
	private int y;
	private int width = 50;
	private int height = 20;
	private int scale;
	private int i = 1;
	private static BufferedImage beam = null;
	private boolean ifBeam = false;
	private static boolean ifTarget = false;
	private int xBeam;
	private int yBeam;

	public PlayerUFO(){
		x = (int)(Math.random() * CityScape.getFrameWidth() - 50); 
		y = (int)(Math.random() * 150); 
		scale = 3; 
		try { 
			beam = ImageIO.read(getClass().getResource("/beam.png"));
		} catch (IOException e) { 
			System.err.println("Beam.png could not be found");
		}
	}
	
	public void paint(Graphics g){
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		if (ifBeam) g.drawImage(beam, x-57, y+20, null);
		g.setColor(new Color(red, green, blue));

		g.fillOval(x+scale*10, y-5*scale, 30*scale, 20*scale);
		g.setColor(Color.decode("#333333"));
		g.fillOval(x, y, width*scale, height*scale);

		if (i == 1) g.setColor(Color.decode("#FFFF33"));
		else g.setColor(Color.WHITE);
		g.fillOval(x+5*scale, y+ 7*scale, 10*scale, 5*scale);

		if (i == 2) g.setColor(Color.decode("#FFFF33"));
		else g.setColor(Color.WHITE);
		g.fillOval(x+20*scale, y+ 7*scale, 10*scale, 5*scale);

		if (i == 3) g.setColor(Color.decode("#FFFF33"));
		else g.setColor(Color.WHITE);
		g.fillOval(x+35*scale, y+ 7*scale, 10*scale, 5*scale);
		if (i == 3) i = 0;
		i++;
	}
	
	public void move(int xM, int yM){
		y += yM*10;
		x += xM*10;
	}
	
	public void track(MouseEvent e){
		x = e.getX() - 75;
		y = e.getY() - 25;
	}
	
	public void beam(Boolean set){
		if (set) ifBeam = true;
		else ifBeam = false;
		
		xBeam = x - beam.getWidth()/5;
		yBeam = y + beam.getHeight();
	}
	
	public void suckUp(Car car){
		if (yBeam >= 700){
			if (xBeam >= car.getX() - car.getWidth()/2 - 80 && xBeam <= car.getX() + car.getWidth()/2 + 120){
				ifTarget = true;
				car.setX(x-80);
				car.remove(this);
			}
		}
		else{
			ifTarget = false;
		}
	}
	
	public static Boolean ifTarget(){
		return ifTarget;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
