/**
 * calculates the amount of water used to create the computer(s) and monitor(s) owned
 *
 * modified 20210809
 * date 20210809
 * @filename WaterAndComputer.java
 * @author Emily Su
 * @version 1.0
 */

import java.util.Scanner;

public class WaterAndComputer {

	public static void main(String[] args) {

		Scanner keyedInput = new Scanner(System.in);

		// declare
		int computerMonitorCombos;
		final double WATER_USED_PER_COMBO = 1.5;
		double totalWaterUsed;

		// prompt and retrieve user information
		System.out.println("Enter the number of computer and monitor combinations that you own:");
		computerMonitorCombos = keyedInput.nextInt();

		// close scanner
		keyedInput.close(); // src: vmso during class

		// calculation
		totalWaterUsed = computerMonitorCombos * WATER_USED_PER_COMBO;

		// output
		if (totalWaterUsed < 0) {
			System.out.println(
					"You cannot input a negative number for how many computers and monitors you own. Please try again.");
		} else {
			System.out
					.println("The total amount of water used to manufacture the computer and monitors that you own is "
							+ totalWaterUsed + " tons.");
		}

	}

}
