import java.awt.Rectangle;
import java.util.ArrayList;


public class Intersection{
	
	ArrayList<Car> left = new ArrayList<Car>();
	ArrayList<Car> right = new ArrayList<Car>();
	ArrayList<Car> up = new ArrayList<Car>();
	ArrayList<Car> down = new ArrayList<Car>();
	
	static boolean isRed = false;
	public static Car[] arrCar = new Car[16];
	Panel mPane;
	
	public Intersection(Panel pane){
		mPane = pane;
		
		for (int x = 0; x < 16; x++){
			arrCar[x] = new Car(pane);
			if (arrCar[x].mDirection == Car.left)
				left.add(arrCar[x]);
			if (arrCar[x].mDirection == Car.right)
				right.add(arrCar[x]);
			if (arrCar[x].mDirection == Car.up)
				up.add(arrCar[x]);
			if (arrCar[x].mDirection == Car.down)
				down.add(arrCar[x]);
		}
	}
	void move(){
		for (Car c:arrCar){
			isClear(c);	
			c.move();
		}
	}

	void isClear(Car c){  
		alreadyPast(c);
		if (c.committed)
			return;
		redLight(c);
		if (c.stopped)
			if (intersectionClear(c))
				c.stopped = false;
//		if (redLight(c)){
//			if (c.mDirection == Car.left && !left.isEmpty() && c == left.get(0))
//				c.stopped = true;
//			if (c.mDirection == Car.right && !right.isEmpty() && c == right.get(0))
//				c.stopped = true;
//			if (c.mDirection == Car.up && !up.isEmpty() && c == up.get(0))
//				c.stopped = true;
//			if (c.mDirection == Car.down && !down.isEmpty() && c == down.get(0))
//				c.stopped = true;
//		}
		
//		else 
//			c.stopped = false;
	}
	void alreadyPast(Car c){
		if (left.contains(c) && c.x < Panel.intersection.x + Panel.intersection.width){
			c.committed = true;
			left.remove(c);
		}
		if (right.contains(c) && c.x + Car.size > Panel.intersection.x){
			c.committed = true;
			right.remove(c);
		}
		if (up.contains(c) && c.y < Panel.intersection.y + Panel.intersection.height){
			c.committed = true;
			up.remove(c);
		}
		if (down.contains(c) && c.y + Car.size> Panel.intersection.y){
			c.committed = true;
			down.remove(c);
		}
	}
	public boolean redLight(Car c){
		if (isRed && (c.mDirection == Car.up || c.mDirection == Car.down)){
			c.stopped = true;
			return true;
		}
		if (!isRed && (c.mDirection == Car.right || c.mDirection == Car.left)){
			c.stopped = true;
			return true;
		}
		c.stopped = false;
		return false;
	}
	boolean intersectionClear(Car c){
		if (!left.isEmpty() && !right.isEmpty() && (left.contains(c) || right.contains(c)) && (left.get(0) == c || right.get(0) == c)){
			for (Car b : up){
				if (b.y < Panel.intersection.y + Panel.intersection.height && b.y > Panel.intersection.y)
					return false;
			}
			for (Car d : down){
				if (d.y < Panel.intersection.y + Panel.intersection.height && d.y > Panel.intersection.y)
					return false;
			}
			return true;
		}
		if (!up.isEmpty() && !down.isEmpty() && (up.contains(c) || down.contains(c)) && (up.get(0) == c || down.get(0) == c)){
			for (Car b : left){
				if (b.x < Panel.intersection.x + Panel.intersection.width && b.x > Panel.intersection.x)
					return false;
			}
			for (Car d : right){
				if (d.x < Panel.intersection.x + Panel.intersection.width && d.x > Panel.intersection.x)
					return false;
			}
			return true;
		}
		return false;		
	}

	

//	public boolean collidingAhead(int a, int b, int c){
//		int[] arr = {a,b,c};
//		for (int i = 0; i < 3; i++){
//			Rectangle r1 = new Rectangle(mPane.arrCar[arr[i]].x, mPane.arrCar[arr[i]].y, size + buffer, size + buffer);
//			Rectangle r2 = new Rectangle(this.x,this.y, size + buffer, size + buffer);
//			if (r1.intersects(r2))
//				return true;
//		}
//		return false;
	
}
