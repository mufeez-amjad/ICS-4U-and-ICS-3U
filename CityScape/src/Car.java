import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Car{
	 
	private BufferedImage car;
	private int x = 500;
	private int xSpeed = 2;
	private int y = 725;
	private boolean toLeft = false;
	private boolean toRight = false;
	private boolean removed = false;
	private static int height;
	private static int width;

	public Car(){
		try {
			car = ImageIO.read(getClass().getResource("/car.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		height = car.getHeight();
		width = car.getWidth();
	}
	
	public void paint(Graphics g){
		if (!removed){
			if (PlayerUFO.ifTarget()){
				if (toRight) g.drawImage(car, x+50, y,width/2, height/2, null);
				else if (toLeft) g.drawImage(car, x + 50 + width, y, -width/2, height/2, null);
				width -= 2;
				height -= 1;
			}
			else{
				if (toRight) g.drawImage(car, x, y, null);
				else if (toLeft) g.drawImage(car, x + car.getWidth(), y, -car.getWidth(), car.getHeight(), null);
			}
		}
	}
	

	public void remove(PlayerUFO p){
		if (y < p.getY()) removed  = true;
	}
	
	public void move(){
		if (PlayerUFO.ifTarget()){
			xSpeed = 0;
			y -= 5;
		}
		if (x + xSpeed < 0){
			xSpeed = 2;
			toRight = true;
			toLeft = false;
		}
		else if (x + xSpeed > CityScape.getFrameWidth() - car.getWidth()){
			xSpeed = -2;
			toLeft = true;
			toRight = false;
		}
			
		x += xSpeed;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int newX){
		 x = newX;
	}
	
	public void setRemoved(){
		 removed = false;
	}
	
	public int getWidth(){
		return width;
	}

}