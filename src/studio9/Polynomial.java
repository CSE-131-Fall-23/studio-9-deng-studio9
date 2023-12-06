package studio9;

import java.util.LinkedList;
import java.util.List;

public class Polynomial {
	
	private LinkedList<Double> list;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		// Create an empty linked list to store coefficients.
		this.list = new LinkedList<>();
	}

	/**
	 * Adds a term to the end of the polynomial.
	 * 
	 * @param coeff the coefficient of the term to be added
	 */
	public void addTerm(double coeff) {
		// Simply add the coefficient to the end of the linked list.
		list.add(coeff);
	}

	/*
	 * Returns a String of the polynomial with the proper form:
	 * 
	 * Cx^N + Cx^N-1 + ... + Cx + C
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();

		// Iterate through the coefficients in reverse order.
		for (int i = list.size() - 1; i >= 0; i--) {
			double coeff = list.get(i);

			// Append the term to the result string.
			if (coeff != 0) {
				if (result.length() > 0) {
					result.append(" + ");
				}

				// Handle the constant term and x term without exponent.
				if (i == 0) {
					result.append(coeff);
				} else if (i == 1) {
					result.append(coeff + "x");
				} else {
					result.append(coeff + "x^" + i);
				}
			}
		}

		// If the result is still empty, the polynomial is zero.
		if (result.length() == 0) {
			result.append("0");
		}

		return result.toString();
	}

	/**
	 * Evaluates the polynomial for a given value of x.
	 * 
	 * @param x the value of x
	 * @return the result of the polynomial evaluation
	 */
	public double evaluate(double x) {
		double result = 0;

		// Iterate through the coefficients and evaluate the polynomial.
		for (int i = 0; i < list.size(); i++) {
			result += list.get(i) * Math.pow(x, i);
		}

		return result;
	}

	/**
	 * Computes the derivative of the polynomial using the power rule.
	 * 
	 * @return a new Polynomial representing the derivative
	 */
	public Polynomial derivative() {
		Polynomial derivative = new Polynomial();

		// Iterate through the coefficients and compute the derivative.
		for (int i = 1; i < list.size(); i++) {
			derivative.addTerm(list.get(i) * i);
		}

		return derivative;
	}
	
	// Equals method remains the same as provided in the original code.

	public boolean equals(Object obj) {
		// ...
	}
}
