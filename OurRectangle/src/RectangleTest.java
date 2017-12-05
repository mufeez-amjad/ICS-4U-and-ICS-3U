public class RectangleTest
{//Constructor 1/2
	//Intersection 4/6
	//Total Perimeter 2/3
	public static void main(String[] args)
	{
		OurRectangle r1 = new OurRectangle(1,2,8,6);
		OurRectangle r2 = new OurRectangle(6,4,3,3);
		
		/*
		OurRectangle r3 = new OurRectangle(0,0,7,8);
		OurRectangle r4 = new OurRectangle(1,1,1,1);

		OurRectangle r5 = new OurRectangle(4,4,2,2);

		System.out.println("toString Test: " + (r1.toString().equals("base: (1,2) w:8 h:6")? "Passed" : "Failed"));

		System.out.println("Area Test: " + (r1.area()==48 ? "Passed" : "Failed"));

		System.out.println("Perimeter Test: " + (r1.perimeter()==28 ? "Passed" : "Failed"));

		System.out.println("Total Perimeter Test: " + (OurRectangle.totalPerimeter(r1,r2)==28 ? "Passed" : "Failed"));
		
		System.out.println("Intersection Test: " + (OurRectangle.intersection(r1,r2).toString().equals("base: (6,4) w:3 h:3")?"Passed":"Failed"));

		
		OurRectangle c = new OurRectangle(3,3,3,3);
		OurRectangle d = new OurRectangle(2,3,0,3);
		*/
		System.out.println("Contains Test: " + (r1.contains(r2) == true?"Passed":"Failed"));
		/*
		OurRectangle a = new OurRectangle(0,0,2,3);
		OurRectangle b = new OurRectangle(2,2,5,1);
		
		//System.out.println(OurRectangle.intersection(a, b).toString());
		System.out.println(OurRectangle.totalPerimeter(a, b));
		
		OurRectangle e = new OurRectangle(0,0,2,3);
		OurRectangle f = new OurRectangle(10,10,5,1);
		System.out.println(OurRectangle.intersection(e, f).toString());
	*/
		
		
	}
}
/*
public class OurRectangle {

//Attributes
private static int rectangleCount = 0;
private int x;
private int y;
private int x2;
private int y2;
private int width;
private int height;

//Constructor
public OurRectangle (int xc, int yc, int w, int h) {

 //Negative checker
 if (width < 0) {width = 0;}
 if (height < 0) {height = 0;}

 //Set variables
 x = xc;
 y = yc;
 width = w;
 height = h;
 // x2/y2 are top right corner
 x2 = x + width;
 y2 = y + height;
 rectangleCount++;
}

//Return co ordinates
public String toString () {
 return "base: (" + x + "," + y + ") w:" + width + " " + "h:" + height;
}

//Return area
public int area() {
 return width * height;
}

//Return perimeter
public int perimeter() {
 return (width * 2) + (height * 2);
}

//Intersection
public static OurRectangle intersection(OurRectangle r1, OurRectangle r2){
   if (intersectionCheck(r1, r2)) {
           //NewX1/NewY1 are bottom left and NewX2/NewY2 are top
right of intersected rectangle
           int newX1, newY1, newX2, newY2;
           newX1 = Math.max(r1.x, r2.x);
           newY1 = Math.max(r1.y, r2.y);
           newX2 = Math.min(r1.x2, r2.x2);
           newY2 = Math.min(r1.y2, r2.y2);
           return new OurRectangle(newX1, newY1, Math.abs(newX1 -
newX2), Math.abs(newY1 - newY2));
       } else {
           return new OurRectangle(0, 0, 0, 0);
       }
}

//Intersection check
private static boolean intersectionCheck (OurRectangle r1, OurRectangle r2) {
  return !(r2.y > r1.y2 || r2.x > r1.x2 || r1.y > r2.y2 || r1.x > r2.x2);
}

//Perimeter
public static int totalPerimeter(OurRectangle r1, OurRectangle r2) {
     OurRectangle newRect = intersection(r1, r2);
     return r1.perimeter()+r2.perimeter()- newRect.perimeter();
   }

//Contained
   public boolean contains(OurRectangle r2) {
       return r2.x >= x && r2.y >= y && r2.x2 <= x2 && r2.y2 <= y2;
   }
}
*/