package test;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("max memory:"+Runtime.getRuntime().maxMemory()/1024/1024);
		System.out.println("free memory:"+Runtime.getRuntime().freeMemory()/1024/1024);
		System.out.println("total memory:"+Runtime.getRuntime().totalMemory()/1024/1024);
		
		byte[] b1=new byte[1*1024*1024];
		
		
		System.out.println("max memory:"+Runtime.getRuntime().maxMemory()/1024/1024);
		System.out.println("free memory:"+Runtime.getRuntime().freeMemory()/1024/1024);
		System.out.println("total memory:"+Runtime.getRuntime().totalMemory()/1024/1024);
	}

}
