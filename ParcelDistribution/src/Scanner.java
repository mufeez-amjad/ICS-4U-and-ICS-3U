import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Scanner {
	private int x = DistributionCenter.getFrameWidth()/2 - 85;
	private int y = DistributionCenter.getFrameHeight()/2 - 40;
	private int side = 125;
	private boolean scanning;
	private boolean domestic;
	private boolean international;
	private boolean unknown;
	private BufferedImage plane;
	private BufferedImage truck;
	private BufferedImage question;
	private static int counted = 0;


	public Scanner(){
		try { 
			plane = ImageIO.read(getClass().getResource("/Plane.png"));
		} catch (IOException e) { 
			System.err.println("Plane.png could not be found");
		}

		try { 
			truck = ImageIO.read(getClass().getResource("/Truck.png"));
		} catch (IOException e) { 
			System.err.println("Truck.png could not be found");
		}

		try { 
			question = ImageIO.read(getClass().getResource("/Question.png"));
		} catch (IOException e) { 
			System.err.println("Question.png could not be found");
		}
	}
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getSide(){
		return side;
	}
	
	public static void count(){
		counted++;
	}

	public void scan(Parcel p){
		int xA = 0, yA = 0;
		scanning = true;
		p.Scan();
		if (p.getColor() == 1){
			xA = 1; 
			yA = 0;;
			international = false;
			unknown = false;
			domestic = true;
			if (p.getX() > x + side) scanning = false;
		}
		if (p.getColor() == 2){
			xA = 0;
			yA = -1;
			unknown = false;
			domestic = false;
			international = true;
			if (p.getY() < 250) scanning = false;
		}
		if (p.getColor() == 3){
			xA = 0;
			yA = 1; 
			international = false;
			domestic = false;
			unknown = true;
			if (p.getY() > y + side) scanning = false;
		}
		if (p.getX() + p.getLength() + 20 == x + side){
			p.sort(xA, yA);
		}
	}

	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				 RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.darkGray);
		g2d.fillRect(x, y, side, side);
		if (!scanning) g2d.setColor(Color.white);
		else g2d.setColor(Color.red);
		g2d.fillOval(x + 5, y+ 5, 20, 20);
		g.drawString("Count: " + counted, x, y+50);

		if (domestic) g2d.drawImage(truck, 50, DistributionCenter.getFrameHeight() - 150, null);
		if (international) g2d.drawImage(plane, 50, DistributionCenter.getFrameHeight() - 150, null);
		if (unknown) g2d.drawImage(question, 50, DistributionCenter.getFrameHeight() - 175, null);

	}
}



