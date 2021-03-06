package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final BlockingQueue queue=new ArrayBlockingQueue(3);
		for(int i=0;i<2;i++) {
			new Thread() {
				@Override
				public void run() {
					while(true) {
						try {
							Thread.sleep((long)(Math.random()*1000));
							System.out.println(Thread.currentThread().getName()+"正在存放数据");
							queue.put(1);
							System.out.println(Thread.currentThread().getName()+"已经存放，目前队列有"+queue.size()+"个数");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}.start();
		}
		
		new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+"准备取数据");
						System.err.println(queue.take());
						System.out.println(Thread.currentThread().getName()+"已经取走数据，现在队列有"+queue.size()+"个数据");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}.start();
	}

}
