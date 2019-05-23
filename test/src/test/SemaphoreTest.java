package test;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	//创建semaphore对象，初始化5个信号
	static Semaphore semaphore=new Semaphore(5,true);
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					test();
				}
			}).start();
		}

	}
	public static void test() {
		try {
			//申请一个请求
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"进来了");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"走了");
		//释放一个请求,新的线程就可以使用
		semaphore.release();
	}
}
