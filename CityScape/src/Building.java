import java.awt.Color;
import java.awt.Graphics;

public class Building {
	private static int tallestHeight = 0;
	private int x, y, winX, winY;
	private int[] bOrY;
	private int drawY;

	public Building(int x, int y, int winX, int winY){
		this.x = x; 
		drawY = y + 160; 
		this.y = y;

		this.winX = winX; 
		this.winY = winY; 

		bOrY = new int[winX*winY];

		for (int i = 0; i < bOrY.length; i++){
			bOrY[i] = (int) (Math.random() * 2);
		}

		if (winY > tallestHeight) tallestHeight = winY + 30;

	}

	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, (drawY-winY*25), winX*25, winY*25);

		int b = 0;
		y = x;
		int count = 0;
		for (int i = 0; i < winY; i++){
			for (int h = 0; h < winX; h++){
				if (bOrY[count] == 0) g.setColor(Color.decode("#FFFF33"));
				else g.setColor(Color.decode("#333333"));

				g.fillRect(5+x, (b + 5 + (860-winY*25)), 15, 15);
				x += 25;
				count++;
			}
			b += 25;
			x = y;
		}
	}
	
	public static int getTallest(){
		return tallestHeight;
	}
}


