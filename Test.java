public class Test {

	public static void main(String[] args) {
		System.out.println("Hi");

		Runnable th = new ThreadTest();
		Thread th1 = new Thread(th);

		th1.start();

		for (int i = 0; i < 100; i++) {
			System.out.println("Main " + i);
		}
	}
}