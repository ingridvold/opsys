/**
 * This class implements the barber's part of the
 * Barbershop thread synchronization example.
 */
//vanligste metode for å implementere threads, er ved å implementere Runnable interfacet, som har metoden run() som kjøres uansett.
public class Barber implements Runnable {
	/**
	 * Creates a new barber.
	 * @param queue		The customer queue.
	 * @param gui		The GUI.
	 * @param pos		The position of this barber's chair
	 */

	private CustomerQueue queue;
	private Gui gui;
	private int pos;
	private Thread thread;


	public Barber(CustomerQueue queue, Gui gui, int pos) {
		this.queue = queue;
		this.gui = gui;
		this.pos = pos;
		this.thread = new Thread(this, "barber " + Integer.toString(pos));
	}

	/**
	 * Starts the barber running as a separate thread.
	 */


	public void startThread() {
		thread.start();
	}

	/**
	 * Stops the barber thread.
	 */
	public void stopThread() {
		// Incomplete
	}

	//hente kunder fra venterommet
	//klippe i en gitt tidsperiode
	//når ferdig, skal frisør vente en stund (pga dagdrømming) før den henter neste kunde.
	//barber konsumerer en kunde, jobber for en gitt periode.
	//er det ingen kunder i kø skal barber vente og bli vekket når det kommer nye kunder i ventekøen.
	// synchronized, wait, notify, notifyAll
	public void work() {
		int min = Globals.MIN_BARBER_WORK;
		int max = Globals.MAX_BARBER_WORK;
		int r = min +(int)(Math.random()*(max-min+1));
		try {
			thread.sleep(r);
			System.out.println("Barber " + (pos+1) + " is working " + r + " milliseconds.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	//dagdrømme i random antall minutter.
	public void dayDream() {
		int min = Globals.MIN_BARBER_SLEEP;
		int max = Globals.MAX_BARBER_SLEEP;
		int r = min +(int)(Math.random()*(max-min+1));
		try {
			thread.sleep(r);
			System.out.println("Barber " + (pos+1) + " is daydreaming " + r + " milliseconds");
		} catch (InterruptedException ie) {
			System.out.println("Barber thread interrupted! " + ie);
		}

	}

	@Override
	public void run() {
		System.out.println("Barber " + (pos+1) + " starting");
		while (true) {
			Customer customer = new Customer();
			gui.fillBarberChair(pos, customer);
			gui.println("Barber " + Integer.toString(pos) + " has placed " + customer.generateName() + " in barberchair");
			gui.println("Barber " + Integer.toString(pos) + " started working");
			work();
			gui.emptyBarberChair(pos);
			gui.println("Barber " + Integer.toString(pos) + " stopped working");
			gui.barberIsSleeping(pos);
			gui.println("Barber " + Integer.toString(pos) + " started daydreaming");
			dayDream();
			gui.println("Barber " + Integer.toString(pos) + " stopped daydreaming");
			gui.barberIsAwake(pos);
		}
	}

	// Add more methods as needed
}


