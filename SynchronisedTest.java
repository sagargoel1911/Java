class Thread1 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + i);
		}
	}
}

class Thread2 implements Runnable {
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + i);
		}
	}
}

public class SynchronisedTest {
	public static void main(String[] args) {
		Thread th11 = new Thread(new Thread1(), "Non-sync-first ");
		Thread th12 = new Thread(new Thread1(), "Non-sync-second ");

		Thread2 syncRunnable = new Thread2();// same object
		Thread th21 = new Thread(syncRunnable, "Sync-first ");
		Thread th22 = new Thread(syncRunnable, "Sync-second ");

		// uncomment for unsync
		th11.start();
		th12.start();

		// uncomment for sync
		th21.start();
		th22.start();
	}
}
