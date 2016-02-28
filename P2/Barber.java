

/**
 * This class implements the barber's part of the
 * Barbershop thread synchronization example.
 */
public class Barber implements Runnable{

    	/**
	 * Creates a new barber.
	 * @param queue		The customer queue.
	 * @param gui		The GUI.
	 * @param pos		The position of this barber's chair
	 */
     private CustomerQueue queue;
     private  Gui gui;
     private  int pos;
     private Thread thread;

	public Barber(CustomerQueue queue, Gui gui, int pos) {
		this.queue = queue;
        this.gui = gui;
        this.pos = pos;
		this.thread = new Thread(this,"Barber" + Integer.toString(pos));





		// Incomplete
	}

	/**
	 * Starts the barber running as a separate thread.
	 */
	public void startThread() {
		thread.start();

		// Incomplete
	}

	/**
	 * Stops the barber thread.
	 */
	public void stopThread() {

		thread.notifyAll();
		//thread.stop();
		// Incomplete
	}


	public void run() {
		//thread.start();
		daydream();
			System.out.print(" \n" + queue + "\n " + pos);
	}

	public void daydream(){
		int minSleep = Globals.MIN_BARBER_SLEEP;
		int maxSleep = Globals.MAX_BARBER_SLEEP;
		int rand = minSleep + (int)(Math.random()*maxSleep-minSleep+1);
		try{
			thread.sleep(rand);
			System.out.print("Apekatt");
		}catch (InterruptedException ie){
			System.out.print("Something whent wrong");
		}
	}
		// Add more methods as needed
}

