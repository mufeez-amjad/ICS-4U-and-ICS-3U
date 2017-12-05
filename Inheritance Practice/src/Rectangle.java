
public class Rectangle extends Shape {
	private int length;
	private int width;
	
	
	public Rectangle(int l, int w){
		length = l;
		width = w;
	}
	
	@Override
	public int area() {
		// TODO Auto-generated method stub
		return length*width;
	}

	@Override
	public int perimeter() {
		// TODO Auto-generated method stub
		return 2*(width+length);
	}

}
