package be.pxl.multithreading.voorbeeld1;

public class RunningDifferentCounters {
	public static void main(String[] args) {
		Counter counter1 = new Counter(OutputColor.GREEN, 10);
		OtherCounter counter2 = new OtherCounter(OutputColor.BLUE, 10);
		counter1.start();//extends thread
		new Thread(counter2).start();//implements runnable
		new Thread(() -> {  //Lambda omdat "runnable" een functionele interface is.
			for (int i = 1; i < 50; i = i * 2) {
				System.out.println("Printing the count " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Lambda thread is over");
		}).start();
	}
}
