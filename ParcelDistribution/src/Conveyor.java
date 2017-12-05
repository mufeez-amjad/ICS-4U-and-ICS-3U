import java.awt.*;


public class Conveyor {
	private int x = 0;
	private int lineX1 = x;
	private int lineX2;
	private int y = DistributionCenter.getFrameHeight()/2 - 25;
	private int length = DistributionCenter.getFrameWidth();
	private int height = 100;
	private boolean domestic = false;
	private boolean international = false;
	private boolean unknown = false;
	private static boolean running = true;
	private int lineY1;
	private int lineY2;
	
	public Conveyor(Scanner sc){
		lineX2 = sc.getX() + sc.getSide();
		lineY1 = sc.getY();
		lineY2 = sc.getY() + sc.getSide();
	}

	public void paint(Graphics g, Scanner sc){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				 RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(Color.GRAY);
		g2d.fillRect(x, y, length, height); //horizontal
		g2d.fillRect(sc.getX() + 10, 0, sc.getSide() - 20, DistributionCenter.getFrameHeight()); //vertical
		g2d.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		if (running){
			g2d.setColor(Color.green);
			g2d.fillRoundRect(x + 10, y - 35, 60, 25, 25, 25);
			g2d.setColor(Color.WHITE);
			g2d.fillOval(x + 45, y - 34, 23, 23);
			g2d.drawString("ON", x + 20, y - 18);

		}
		else{
			g2d.setColor(Color.red);
			g2d.fillRoundRect(x + 10, y - 35, 60, 25, 25, 25);
			g2d.setColor(Color.WHITE);
			g2d.fillOval(x + 13, y - 34, 23, 23);
			g2d.drawString("OFF", x + 40, y - 18);
		}

		g2d.setColor(Color.darkGray);

		g2d.drawLine(lineX1, y, lineX1 , y + height); //entry
		g2d.drawLine(lineX1 + 85, y, lineX1 + 85, y + height);
		g2d.drawLine(lineX1 + 170, y, lineX1 + 170, y + height);
		g2d.drawLine(lineX1 + 255, y, lineX1 + 255, y + height);
		g2d.drawLine(lineX1 + 340, y, lineX1 + 340, y + height);
		if (lineX1 + 340 >= sc.getX()) lineX1 = x; //425
		if (running) lineX1++;

		g2d.drawLine(lineX2, y, lineX2 , y + height); //domestic
		g2d.drawLine(lineX2 + 85, y, lineX2 + 85, y + height);
		g2d.drawLine(lineX2 + 170, y, lineX2 + 170, y + height);
		g2d.drawLine(lineX2 + 255, y, lineX2 + 255, y + height);
		g2d.drawLine(lineX2 + 340, y, lineX2 + 340, y + height);
		g2d.drawLine(lineX2 + 425, y, lineX2 + 425, y + height);

		if (domestic){
			if (lineX2 + 425 >= DistributionCenter.getFrameWidth() + 40) lineX2 = sc.getX() + sc.getSide();
			lineX2 ++;			
		}

		g2d.drawLine(sc.getX() + 10, lineY1, sc.getX() + sc.getSide()-10, lineY1); //international
		g2d.drawLine(sc.getX() + 10, lineY1 - 85, sc.getX() + sc.getSide()-10, lineY1 - 85);
		g2d.drawLine(sc.getX() + 10, lineY1 - 170, sc.getX() + sc.getSide()-10, lineY1 - 170);
		g2d.drawLine(sc.getX() + 10, lineY1 - 255, sc.getX() + sc.getSide()-10, lineY1 - 255);
		g2d.drawLine(sc.getX() + 10, lineY1 - 340, sc.getX() + sc.getSide()-10, lineY1 - 340);

		if (international){
			if (lineY1 - 255 < -60) lineY1 = sc.getY();
			lineY1--;
		}

		g2d.drawLine(sc.getX() + 10, lineY2, sc.getX() + sc.getSide()-10, lineY2); //unknown
		g2d.drawLine(sc.getX() + 10, lineY2 + 85, sc.getX() + sc.getSide()-10, lineY2 + 85);
		g2d.drawLine(sc.getX() + 10, lineY2 + 170, sc.getX() + sc.getSide()-10, lineY2 + 170);
		g2d.drawLine(sc.getX() + 10, lineY2 + 255, sc.getX() + sc.getSide()-10, lineY2 + 255);


		if (unknown){
			if (lineY2 + 170 > DistributionCenter.getFrameHeight() + 20) lineY2 = sc.getY() + sc.getSide();
			lineY2++;
		}
	}

	public void startStop(){
		if (running){
			running = false; 
		}
		else{
			running = true;
		}
	}

	public Boolean getRunning(){
		return running;
	}

	public void update(Parcel[] parcels, Scanner sc){
		domestic = false;
		international = false;
		unknown = false; 
		
	
		for (int i = 0; i < parcels.length; i++){
			if (parcels[i].getX() + 30 >= sc.getX() + sc.getSide() && parcels[i].getX() < DistributionCenter.getFrameWidth() + 40){
				domestic = true;
			}

			if (parcels[i].getY() <= sc.getY() && parcels[i].getY() + 50 > 0){
				international = true;
			}

			if (parcels[i].getY() + 50 >= sc.getY() + sc.getSide() && parcels[i].getY() < DistributionCenter.getFrameHeight()){
				unknown = true;
			}
		}
	}
}
