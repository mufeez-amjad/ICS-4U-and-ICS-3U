
public class Triangle extends Shape {
	
	private int a;
	private int b;
	private int c;
	
	public Triangle(int s1, int s2, int s3){
		a = s1;
		b = s2;
		c = s3;
	}
	@Override
	public int area() {
		double s = (a+b+c)/2;
		return (int) Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}

	@Override
	public int perimeter() {
		return a+b+c;
	}

}
