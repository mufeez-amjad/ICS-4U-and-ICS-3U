
public class OurRectangle {

	private int x1, y1, x2, y2, width, height;


	public OurRectangle(int x, int y, int w, int h){
		if (w < 0) w = 0;
		if (h < 0) h = 0;

		x1 = x;
		y1 = y;
		width = w;
		height = h;

		x2 = x1 + width;
		y2 = y1 + height;
	}

	public String toString(){
		return "base: (" + x1 + "," + y1 + ") w:" + width + " h:" + height;
	}

	public int area(){
		return width*height;
	}

	public int perimeter(){
		return 2 * (width + height);
	}

	public static OurRectangle intersection(OurRectangle r1, OurRectangle r2){
		OurRectangle intersect;

		//co-ordinates of the resulting rectangle
		int ix1, iy1, ix2, iy2;
		ix1 = Math.max(r1.x1, r2.x1);
		iy1 = Math.max(r1.y1, r2.y1);
		ix2 = Math.min(r1.x2, r2.x2);
		iy2 = Math.min(r1.y2, r2.y2);

		int iWidth, iHeight;

		iWidth = Math.abs(ix2-ix1);
		iHeight = Math.abs(iy2-iy1);

		// to the left, right, top or bottom
		// not intersecting
		if ((r2.x1 > r1.x2 || r1.x1 > r2.x2 || r2.y1 > r1.y2 || r1.y1 > r2.y2)){
			intersect = new OurRectangle(0, 0, 0, 0);
		}

		//intersecting or touching
		else {
			intersect = new OurRectangle(ix1, iy1, iWidth, iHeight); 
		}

		return intersect;
	}

	public static int totalPerimeter(OurRectangle r1, OurRectangle r2){
		return r1.perimeter() + r2.perimeter() - (intersection(r1,r2).perimeter());
	}

	public boolean contains(OurRectangle r){
		return (this.x1 <= r.x1 && this.y2 >= r.y2 && this.x2 >= r.x2 && this.y1 <= r.y1);
	}

}
