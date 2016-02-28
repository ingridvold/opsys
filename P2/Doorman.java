/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman implements Runnable {
	/**
	 * Creates a new doorman.
	 * @param queue		The customer queue.
	 * @param gui		A reference to the GUI interface.
	 */

	private CustomerQueue queue;
	private Gui gui;
	private Thread thread;

	public Doorman(CustomerQueue queue, Gui gui) {
		this.queue = queue;
		this.gui = gui;
		this.thread = new Thread(this, "doorman");
	}

	/**
	 * Starts the doorman running as a separate thread.
	 */
	public void startThread() {
		thread.start();
	}

	//slippe inn en og en kunde etter gitt tid
	//er ventekøen full, så venter dørmannen (wait() ? )
	//når det blir ledig plass i ventekøen må dørmannen fortsette

	public void sleep() {
		int min = Globals.MIN_DOORMAN_SLEEP;
		int max = Globals.MAX_DOORMAN_SLEEP;
		int r = min +(int)(Math.random()*(max-min+1));
		try {
			thread.sleep(r);
			System.out.println("Doorman is daydreaming for " + r + " milliseconds");
		} catch(InterruptedException ie) {
			System.out.println("Doorman thread interrupted! " + ie);
		}
	}

	public void addCustomer() {
		Customer customer = new Customer();
		gui.println("Doorman: 'New customer, " + customer.generateName() + "'");
	}

	/**
	 * Stops the doorman thread.
	 */
	public void stopThread() {
		// Incomplete
	}

	@Override
	public void run() {
		while(true){
			addCustomer();
			sleep();
		}
	}

	// Add more methods as needed
}
