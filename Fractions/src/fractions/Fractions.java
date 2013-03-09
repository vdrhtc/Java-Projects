package fractions;

import java.util.*;

public class Fractions {
	
	public static void sort(Fraction[] fracArr) {
		Arrays.sort(fracArr);
	}
	public static double getReal(Fraction fraction) {
		
		double a = fraction.getNumerator();
		double b = fraction.getDenominator();
		
		return a/b;
	}
}
