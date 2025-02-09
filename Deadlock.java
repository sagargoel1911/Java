
public class Deadlock {
	static Object R1 = new Object(), R2 = new Object();

	static class Class1 implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				synchronized (R2) {
					Thread.sleep(1000);
					synchronized (R1) {
						System.out.println("Reached here 2");
					}
				}

			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

	static class Class2 implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				synchronized (R1) {
					Thread.sleep(1000);
					synchronized (R2) {
						System.out.println("Reached here 2");
					}
				}

			} catch (InterruptedException e) {
				System.out.println(e);
			}

		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Class1());
		Thread t2 = new Thread(new Class2());

		t1.start();
		t2.start();
	}
}
