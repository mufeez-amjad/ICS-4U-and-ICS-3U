public class Fraction
{
  //Attributes
  private int numerator;
  private int denominator;
  
  
  
  //Constructor
  public Fraction(int n, int d)
  {
	  numerator = n;
	  denominator = d;
  }
  
  //Accessors
  public int getNumerator(){
	  return numerator;
  }
  
  public int getDenominator(){
	  return denominator;
  }
  //Mutators
  
  
  //Methods
  public void reduce()
  {
	  int GCD = findGCD(numerator, denominator);
	  
	  if (GCD == 1){
		  System.out.println(toString() + " is already simplified.");
	  }
	  else if (GCD > 1){
		  numerator /= GCD;
		  denominator /= GCD;
		  System.out.println(toString());
	  }
  }
  public int findGCD(int n, int d){
	  {		  
		  while (n!=0 && d!=0)
		    {
		        int temp = d;
		        d = n % d; 
		        n = temp;
		    }
		    return n+d;
		}
  }
  
  //add another fraction to this instance
  public void add(Fraction other)
  {
	  Fraction answer;
	  if (this.denominator == other.getDenominator()){
		  answer = new Fraction(this.numerator + other.getNumerator(), denominator);
	  }
	  else {
		  int newDen = this.denominator * other.getDenominator();
          int newNum = this.numerator * other.getDenominator();
          newNum += other.getNumerator() * this.denominator;
          answer = new Fraction(newNum, newDen);          
	  }
	  answer.reduce();
	  
	  System.out.println("The answer is " + answer.toString() + ".");
  }
  
  //subtracts another fraction from this instance
  public void subtract(Fraction other)
  {
	  Fraction answer;

      if(this.denominator == other.getDenominator())
      {
          answer = new Fraction(this.numerator - other.getNumerator(), this.denominator);
      }
      else
      {
          denominator = this.denominator / other.getDenominator();
          numerator = this.numerator / other.getNumerator() - other.getNumerator() * this.denominator; 
          //numerator -= other.getNumerator() * this.denominator;
          answer = new Fraction(numerator, denominator);
      }
      answer.reduce();
	  
	  System.out.println("The answer is " + answer.toString() + ".");
  }
  
  public void reciprocal()
  {
  }
  
  public double value()
  {
	return denominator;
  }
  
  public String toString()
  {
	  return(numerator + "/" + denominator);
  }
  
  public String toMixed()
  {
	return null;
  }
}