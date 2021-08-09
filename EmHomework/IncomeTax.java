/**
 * calculates the income tax of a salary in Canada
 *
 * modified 20210809
 * date 20210809
 * @filename IncomeTax.java
 * @author Emily Su
 * @version 1.0
 */

import java.util.Scanner;

public class IncomeTax {

	public static void main(String[] args) {

		Scanner keyedInput = new Scanner(System.in);

		// declare
		double salary;
		final double FIRST_TAX_RATE = 0.15;
		final double SECOND_TAX_RATE = 0.205;
		final double THIRD_TAX_RATE = 0.26;
		final double FOURTH_TAX_RATE = 0.29;
		final double FIFTH_TAX_RATE = 0.33;
		double incomeTax = 0;
		double incomeTaxRounded;

		// prompt and retrieve user information
		System.out.println("Enter the numerical value of your salary (without the dollar sign):");
		salary = keyedInput.nextDouble();

		// close scanner
		keyedInput.close(); // src: vmso during class

		// calculations
		if (salary < 0) {
			System.out.println("The number you entered for your salary is invalid. Please run the program again.");
		} else if (salary <= 49020) {
			incomeTax = salary * FIRST_TAX_RATE;
		} else if ((salary > 49020) && (salary <= 98040)) {
			incomeTax = (salary - 49020) * SECOND_TAX_RATE + 7353;
		} else if ((salary > 98040) && (salary <= 151978)) {
			incomeTax = (salary - 98040) * THIRD_TAX_RATE + 17402.10;
		} else if ((salary > 151978) && (salary <= 216511)) {
			incomeTax = (salary - 151978) * FOURTH_TAX_RATE + 31425.98;
		} else if (salary > 216511) {
			incomeTax = (salary - 216511) * FIFTH_TAX_RATE + 50140.55;
		}

		// rounding
		incomeTaxRounded = Math.round(incomeTax * 100.0) / 100.0; // https://www.delftstack.com/howto/java/how-to-round-a-double-to-two-decimal-places-in-java/

		// output
		System.out.println("You owe $" + incomeTaxRounded + (" as income tax for your salary of $" + salary + "."));

	}

}
