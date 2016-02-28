import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 * This class implements a customer's part of the Barbershop example.
 * This is a passive class just holding data.
 */
public class Customer implements Constants {
	/** The ID of the next customer to be created */
	public static int nextID = 0;
	/** The ID of this customer */
	private int customerID;
	/** An integer specifying the look of this customer, used by the GUI only */
	private int customerLook;
	private String customerName;

	/**
	 * Creates a new customer, giving him a unique ID and a random look.
	 */
	public Customer() {
		customerID = ++nextID;
		customerLook = (int)(Math.random()*NOF_CUSTOMER_LOOKS);
		customerName = generateName();
	}

	/**
	 * Returns the ID of this customer.
	 * @return	The ID of this customer.
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * Returns an image with the look of this customer. Used by the GUI.
	 * @return	The image with the look of this customer.
	 */
	public Image getImage(){
		return BarbershopGui.customerImages[customerLook];
	}

	public String generateName() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Leif");
		names.add("Ingrid");
		names.add("Hanna");
		names.add("Anne");
		names.add("Eirik");
		names.add("Lars");
		names.add("Sondre");
		names.add("Nikolai");
		int random = new Random().nextInt(names.size());
		String RandName = names.get(random);
		customerName = RandName;
		return customerName;
	}
}
