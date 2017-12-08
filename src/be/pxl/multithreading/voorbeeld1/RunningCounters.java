package be.pxl.multithreading.voorbeeld1;

public class RunningCounters {

	public static void main(String args[])
	   {
	      Counter counter1 = new Counter(OutputColor.GREEN, 10);
	      Counter counter2 = new Counter(OutputColor.CYAN, 15);
	      counter1.start();//thread altijd met start, niet run!
	      counter2.start();
	      try
	      {
	         while(counter1.isAlive() && counter2.isAlive())
	         {
	           System.out.println("Main thread going to sleep");
	           Thread.sleep(1500);
	           counter2.interrupt();	           
	         }
	      }
	      catch(InterruptedException e)
	      {
	        System.out.println("Main thread interrupted");
	      }
	      System.out.println("Main thread's run is over" );
	   }
	
}
