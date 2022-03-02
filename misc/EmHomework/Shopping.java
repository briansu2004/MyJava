/**
 * calculates the subtotal, taxes, and grand total to buy USB storage devices, keyboards, and computer mice
 *
 * modified 20210809
 * date 20210809
 * @filename Shopping.java
 * @author Emily Su
 * @version 1.0
 */

import java.util.Scanner;

public class Shopping {

	public static void main(String[] args) {

		Scanner keyedInput = new Scanner(System.in);

		// declare
		int usbStorageDevices;
		int keyboards;
		int computerMice;
		final double USB_PRICE = 19.99;
		final double KEYBOARD_PRICE = 49.99;
		final double MOUSE_PRICE = 25.99;
		final double TAX_RATE = 0.13;
		double subtotal;
		double taxes;
		double grandTotal;
		double subtotalRounded;
		double taxesRounded;
		double grandTotalRounded;

		// prompt and retrieve user information
		System.out.println("Enter how many USB storage devices you would like to purchase:");
		usbStorageDevices = keyedInput.nextInt();

		System.out.println("Enter how many keyboards you would like to purchase:");
		keyboards = keyedInput.nextInt();

		System.out.println("Enter how many computer mice you would like to purchase:");
		computerMice = keyedInput.nextInt();

		// close scanner
		keyedInput.close(); // src: vmso during class

		// calculations
		subtotal = usbStorageDevices * USB_PRICE + keyboards * KEYBOARD_PRICE + computerMice * MOUSE_PRICE;
		taxes = subtotal * TAX_RATE;
		grandTotal = subtotal + taxes;

		// rounding
		subtotalRounded = Math.round(subtotal * 100.0) / 100.0; // https://www.delftstack.com/howto/java/how-to-round-a-double-to-two-decimal-places-in-java/
		taxesRounded = Math.round(taxes * 100.0) / 100.0; // https://www.delftstack.com/howto/java/how-to-round-a-double-to-two-decimal-places-in-java/
		grandTotalRounded = Math.round(grandTotal * 100.0) / 100.0; // https://www.delftstack.com/howto/java/how-to-round-a-double-to-two-decimal-places-in-java/

		// output
		if (usbStorageDevices < 0 || keyboards < 0 || computerMice < 0) {
			System.out.println(
					"One or more of the numbers you entered for your order is (are) invalid. Please run the program again.");
		} else {
			System.out.println("The subtotal for your order is $" + subtotalRounded + ".");
			System.out.println("The sales tax for your order is $" + taxesRounded + ".");
			System.out.println("The grand total for your order is $" + grandTotalRounded + ".");
		}

	}

}
