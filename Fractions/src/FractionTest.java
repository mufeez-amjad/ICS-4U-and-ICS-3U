public class FractionTest
{
  
  public static void main(String[] args)
  {
	  
    Fraction a = new Fraction(1,2);
    Fraction b = new Fraction(4,6);
    Fraction c = new Fraction(5,4);
    
    /*System.out.println(a.getNumerator() + "/" + a.getDenominator());

    System.out.println(a.toString());
    
    System.out.println(b.toString());
    b.reduce();
    System.out.println(b.toString());
    
    //System.out.println(c.toMixed());
    */
    
    a.add(b);
    c.subtract(a);
    //System.out.println(a.toString());
    
    
    
  }
}