import java.awt.*;
import java.util.Random;

public class Parcel {
	private int height = 0;
	private int length = 0;
	private int width = 0;
	private int color = 3;
	private int x = -100;
	private int  xA = 1;
	private int y = DistributionCenter.getFrameHeight()/2;
	private static int number = 0;
	Random rand = new Random();
	private int yA = 0;
	private boolean scanned = false;

	public Parcel(){
		height = rand.nextInt(30) + 20;
		length = rand.nextInt(30) + 20;  
		width = rand.nextInt(40) + 10;
		color = rand.nextInt(3) + 1;
		//color = 3;
		x -= number * 200;
		number++;
	}

	public void Scan(){
		scanned = true;
	}

	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				 RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (getColor() == 1) g2d.setColor(Color.green);
		if (getColor() == 2) g2d.setColor(Color.blue);
		if (getColor() == 3) g2d.setColor(Color.yellow);

		g2d.fillRect(x, y, length, height);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, length, height);

		int[] xPol1 = {x - width, x, x, x - width};
		int[] yPol1 = {y - width/2, y, y + height, y + height - width/2};

		if (getColor() == 1) g2d.setColor(Color.green);
		if (getColor() == 2) g2d.setColor(Color.blue);
		if (getColor() == 3) g2d.setColor(Color.yellow);

		g2d.fillPolygon(xPol1, yPol1, 4);
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(xPol1, yPol1, 4); 

		if (getColor() == 1) g2d.setColor(Color.green);
		if (getColor() == 2) g2d.setColor(Color.blue);
		if (getColor() == 3) g2d.setColor(Color.yellow);

		int[] xPol2 = {x - width, x + length - width, x + length, x};
		int[] yPol2 = {y - width/2, y - width/2, y, y};
		g2d.fillPolygon(xPol2, yPol2, 4);
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(xPol2, yPol2, 4);

	}

	public void update(Scanner sc){
		if (x + 30 > sc.getX()){
			if (!scanned) Scanner.count();
			sc.scan(this);
		}
		x += xA;
		y += yA;
	}

	public void stopStart(Conveyor c, Scanner sc){
		if (!scanned){
			if (c.getRunning()) xA = 1;
			else xA = 0;
		}
		else if (x < sc.getX()){
			if (c.getRunning()) xA = 1;
			else xA = 0;
		}
		//System.out.println("SPACE");
	}

	public int getColor() {
		return color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	public void sort(int xA, int yA){
		this.xA = xA;
		this.yA = yA;
	}

	public int getHeight() {
		return height;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

}
