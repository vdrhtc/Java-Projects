package fractions;

public class Fraction implements Comparable<Fraction> {

	public Fraction(int numerator, int denominator) {

		this.numerator = numerator;
		this.denominator = denominator;

	}

	public Fraction() {

		this.numerator = 0;
		this.denominator = 1;

	}

	public Fraction add(Fraction other) {

		Fraction result = new Fraction();

		result.numerator = this.numerator * other.denominator
				+ this.denominator * other.numerator;
		result.denominator = this.denominator * other.denominator;

		result.cancel();
		
		return result;
	}
	
	public Fraction subtract(Fraction other) {
		
		Fraction result = new Fraction();

		result.numerator = this.numerator * other.denominator
				- this.denominator * other.numerator;
		result.denominator = this.denominator * other.denominator;

		result.cancel();
		
		return result;
	}
	
	public Fraction multiply(Fraction that) {
		
		Fraction result = new Fraction();
		
		result.numerator = this.numerator*that.numerator;
		result.denominator = this.denominator*that.denominator;
		
		result.cancel();
		
		return result;

	}
	
	public Fraction divise(Fraction that) {
		
		Fraction result = new Fraction();

		result.numerator = this.numerator*that.denominator;
		result.denominator = this.denominator*that.numerator;
		
		result.cancel();
		
		return result;

	}
	
	public int compareTo(Fraction other) {
		
		return this.numerator * other.denominator
				- this.denominator * other.numerator;
	}

	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	private void cancel() {

		int commonDivisor = 1;

		while (Math.abs(this.numerator) != 1 && Math.abs(this.denominator) != 1
				&& commonDivisor <= Math.abs(this.numerator)
				&& commonDivisor <= Math.abs(this.denominator)) {
			commonDivisor++;
			while (this.numerator % commonDivisor == 0
					&& this.denominator % commonDivisor == 0) {
				this.denominator /= commonDivisor;
				this.numerator /= commonDivisor;
			}
		}
	}
	
	public void printSelf(String arg) {
		if(arg.equals("improper"))
			System.out.printf("%d/%d\n", this.numerator, this.denominator);
		else if(arg.equals("proper") && this.numerator/this.denominator !=0 )
			System.out.printf("%d %d/%d\n", this.numerator/this.denominator, this.numerator-(this.numerator/this.denominator)*this.denominator, this.denominator);
		else 
			this.printSelf("improper");
	}
	
	public String toString(){
		return this.numerator+"/"+this.denominator;
	}


	private int numerator;
	private int denominator;
}