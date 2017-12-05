import java.awt.Color;
import java.awt.Graphics;

public class UFO {
	private int x;
	private int y;
	private int xSpeed = 1;
	private int ySpeed = 1;
	private static final int width = 50;
	private static final int height = 20;
	private int scale;
	private int i = 1;
	public UFO(){
		x = (int)(Math.random() * CityScape.getFrameWidth()); 
		y = (int)(Math.random() * 125); 
		//scale = (int) (Math.random() * 4); 
		scale = 3;
	}

	public void paint(Graphics g){
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);

		g.setColor(new Color(red, green, blue));

		g.fillOval(x+scale*10, y-5*scale, 30*scale, 20*scale);
		g.setColor(Color.GRAY);
		g.fillOval(x, y, width*scale, height*scale);

		if (i == 1 || i == 2) g.setColor(Color.decode("#FFFF33"));
		else g.setColor(Color.WHITE);
		g.fillOval(x+5*scale, y+ 7*scale, 10*scale, 5*scale);

		if (i == 3 || i == 4) g.setColor(Color.decode("#FFFF33"));
		else g.setColor(Color.WHITE);
		g.fillOval(x+20*scale, y+ 7*scale, 10*scale, 5*scale);

		if (i == 5 || i == 6) g.setColor(Color.decode("#FFFF33"));
		else g.setColor(Color.WHITE);
		g.fillOval(x+35*scale, y+ 7*scale, 10*scale, 5*scale);
		
		if (i == 6) i = 0;
		i++;

	}

	public void update(){
		if (x + xSpeed < 0){
			xSpeed = 1;
		}

		if (x + xSpeed > CityScape.getFrameWidth() - width*scale){
			xSpeed = -1;
		}

		if (y + ySpeed < 0){
			ySpeed = 1;
		}

		if (y + ySpeed > Building.getTallest() + 115){
			ySpeed = -1;
		}

		y += ySpeed;
		x += xSpeed;
	}
	
	public void collision(UFO u){
		int dx = (x-u.x) + (xSpeed-u.xSpeed);
		int dy = (y-u.y) + (ySpeed-u.ySpeed);
		
		if (Math.sqrt(dx*dx+dy*dy) <= 3*width){
			int tempxa = xSpeed;
			int tempya = ySpeed;
			xSpeed = u.xSpeed;
			ySpeed = u.ySpeed;
			u.xSpeed = tempxa;
			u.ySpeed = tempya;
		}
		
		if (Math.sqrt(dx*dx+dy*dy) <= 110){
			int tempxa = xSpeed;
			int tempya = ySpeed;
			xSpeed = u.xSpeed;
			ySpeed = u.ySpeed;
			u.xSpeed = tempxa;
			u.ySpeed = tempya;
		}
	}
}
