package test;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ThreadTest {
	public static void main(String[] args) {
		final Bussiness bussiness=new Bussiness();
		//子线程
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<2;i++) {
					bussiness.subMethod();
				}
			}
		}).start();
		for(int i=0;i<2;i++) {
			bussiness.mainMethod();
		}
	}
	
	static class Bussiness{
		private boolean subFlag=false;
		
		public synchronized void mainMethod() {
			while(subFlag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int i=0;i<3;i++) {
				System.out.println(Thread.currentThread().getName() +subFlag+ " : main thread running loop count -- " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			subFlag=true;
			notify();
		}
		
		public synchronized void subMethod() {
			while(!subFlag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int i=0;i<5;i++) {
				System.err.println(Thread.currentThread().getName() +subFlag+ " : sub thread running loop count -- " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			subFlag=false;
			notify();
		}
	}
}
