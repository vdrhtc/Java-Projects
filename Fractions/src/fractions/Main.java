package fractions;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			System.out.println("For operating with two fractions a/b and c/d you should enter four ints a b c d and a string 'proper' or 'improper' to choose representation style\nExample: 43 56 78 98 proper"); 
		
		Scanner in = new Scanner(System.in);

		Fraction f1 = new Fraction(in.nextInt(), in.nextInt());
		Fraction f2 = new Fraction(in.nextInt(), in.nextInt());
		String representation = in.next();
		Fraction[] res = new Fraction[4];
		char[] actions = {'+', '-', '/', '*'};
		
		res[0] = f1.add(f2);
		res[1] = f1.subtract(f2);
		res[2] = f1.divise(f2);
		res[3] = f1.multiply(f2);
		
		System.out.println("Results:");
		for(int i=0; i<=3; i++)
		{
			System.out.printf("%c: ", actions[i]);
			res[i].printSelf(representation);
		}
		if (f1.compareTo(f2) < 0)
			System.out.printf("%d/%d < %d/%d\n", f1.getNumerator(),
					f1.getDenominator(), f2.getNumerator(), f2.getDenominator());
		else if (f1.compareTo(f2) > 0)
			System.out.printf("%d/%d > %d/%d\n", f1.getNumerator(),
					f1.getDenominator(), f2.getNumerator(), f2.getDenominator());
		else
			System.out.printf("Fractions are equal\n");
		
		System.out.printf("Fraction 2 real representation: %f\n", Fractions.getReal(f2));
		Fractions.sort(res);
		System.out.println("Sorted results: "+Arrays.toString(res));
		
	}

}
