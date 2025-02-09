class Thread1 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println("T1 " + i);
		}
	}
}

class Thread2 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println("T2 " + i);
		}
	}
}

public class ThreadJoin {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2());

		t1.start();
		t2.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		System.out.println("Main ends here");
	}
}
