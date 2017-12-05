import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Car {
	public static int slot = 0;
	private static final int buffer = 50; 
	static final int size = 35;
	public static final int up = 0, right = 1, down = 2, left = 3; // direction
	int mDirection, mSlot;
	int x,y, a;
	Intersection inter;
	Panel mPane;
	boolean committed = false, stopped = false;
	BufferedImage imgCar;
		
	public void paint(Graphics2D g){
		imgCar = null;
		try {
			imgCar = ImageIO.read(new File("car.jpg"));
		} catch (IOException e) {}
		
		g.drawImage(createResizedCopy(imgCar, size, size, false),x,y, null);
	}
	public Car(Panel pane){
		mPane = pane; 
		if (slot < 4){
			mDirection = up;
			x = Panel.intersection.x + Panel.intersection.width - 3*size/2;
			y = mPane.getHeight()/2 + 2*slot*size + Panel.intersection.height + buffer;
		}
		else if (slot < 8){
			mDirection = down;
			x = Panel.intersection.x + size/2;
			y = mPane.getHeight()/2 - 2*(slot-4)*size - (Panel.intersection.height + buffer);
		}
		else if (slot < 12){
			mDirection = left;
			y = Panel.intersection.y + size/2;
			x = mPane.getWidth()/2 + 2*(slot-8)*size + Panel.intersection.width + buffer;
		}
		else if (slot < 16){
			mDirection = right;
			y = Panel.intersection.y + Panel.intersection.height - 3*size/2;
			x = mPane.getWidth()/2 - 2*(slot-12)*size - (Panel.intersection.width + buffer);
		}
		mSlot = slot;
		++slot;
	}
	public void move(){
		if (mDirection == up || mDirection == left)
			a = -1;
		else
			a = 1;
		if (stopped && !committed)
			a = 0;
		if (mDirection == up || mDirection == down)
			y += a; 
		else
			x += a; 
	}
	
	private BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight, boolean preserveAlpha){
    	int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
    	BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
    	Graphics2D g = scaledBI.createGraphics();
    	if (preserveAlpha) {
    		g.setComposite(AlphaComposite.Src);
    	}
    	g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
    	g.dispose();
    	return scaledBI;
    }
}
