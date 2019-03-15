package test;

public class ThreadLocalTest {

	public static void main(String[] args) {
		final ThreadLocal<Integer> th=new ThreadLocal<Integer>();
		th.set(30);
		new Thread() {
			public void run() {
				th.set(10);
				System.out.println("thread=="+th.get());
			}
		}.start();
		System.out.println("threadLocal=="+th.get());
	}

}
