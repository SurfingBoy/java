package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.print.DocFlavor.STRING;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
//		byte b1=127,b2=2,b;
//		b=(byte) (b1+b2);
//		System.out.println(b);
//		System.out.println('a'+1+"hello");
//		System.out.println("5+5="+5+5);
//		System.out.println(5+5+"=5+5");
		
//		Scanner scanner=new Scanner(System.in);
//		String nString=scanner.nextLine();
//		while(!nString.equals("end")) {
//			System.out.println(nString);
//			nString=scanner.nextLine();
//		}
//		System.out.println("结束");
		
//		int a = 5;
//		int b = (a++)+(a++)+(a*10);
//		System.out.println(a);
//		System.out.println(b);


//		int x=1;
//		int m=2;
//		String xString="wewew";
//		String yString="兑换时间";
//		BigInteger bi = new BigInteger("2147483648");
//		System.out.println(bi);

//		StringBuffer stringBuffer=new StringBuffer();
//		stringBuffer.append("fdfdfd");
//		stringBuffer.append(23);
//		System.out.println(stringBuffer);

		
//		String s1 = "Programming";
//		String s2 = new String("Programming"); 
//		String s3 = "Program"; 
//		String s4 = "ming"; 
//		String s5 = "Program" + "ming"; 
//		String s6 = s3 + s4;
//		System.out.println(s1 == s2); 
//		System.out.println(s1 == s5); 
//		System.out.println(s1 == s6); 
//		System.out.println(s1 == s6.intern()); 
//		System.out.println(s2 == s2.intern());
		
//		String s = new String("1");
//		s.intern();
//		String s2 = "1";
//		System.out.println(s == s2);
//
//		String s3 = new String("1") + new String("1");
//		s3.intern();
//		String s4 = "11";
//		System.out.println(s3 == s4);
		
//		LocalDateTime dTime=LocalDateTime.now();
//		Date dtDate=new Date();
//		System.out.println(dTime.toString());
//		System.out.println(dtDate.toString());
		
//		int[] arr = {1,4,1,4,2,5,4,5,8,7,8,77,88,5,4,9,6,2,4,1,5};
//		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
//		for(int i=0;i<arr.length;i++) {
//			map.put(arr[i], map.get(arr[i])==null?1:map.get(arr[i])+1);
//		}
//		for (Entry<Integer, Integer> m : map.entrySet()) {
//			System.out.println(m.getKey()+" 出现："+m.getValue()+" 次");
//		}
		
		/**下标运用,排序**/
//		int[] arr={5,12,13,1,20,8,5};
//		int[] temp=new int[21];
//		for(int i=0;i<arr.length;i++) {
//			temp[arr[i]]++;
//		}
//		
//		for(int i=0;i<21;i++) {
//			for(int j=0;j<temp[i];j++) {
//				System.out.println(i);
//			}
//		}
		
//		MyThread thread1=new MyThread();
//		MyThread thread2=new MyThread();
//		thread1.start();
//		thread2.start();
		
		//MyThread thread3=new MyThread();
//		Thread thread=new Thread(thread3);
//		thread.start();
		
		//arraylist动态代理
//		final List<String> list=new ArrayList<String>();
//		
//		List<String> proxyInstanceList=(List<String>)Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(),
//				new InvocationHandler() {
//					
//					@Override
//					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//						// TODO Auto-generated method stub
//						long time=System.currentTimeMillis();
//						Object object=method.invoke(list, args);
//						long endtime=System.currentTimeMillis();
//						System.out.println(method.getName()+"运行时长"+(endtime-time));
//						return object;
//						
//					}
//				});
//		proxyInstanceList.add("哈哈哈");
//		System.out.println(list);
		
		List<String> G7=Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada"); 
		String G7countries=G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining("-"));
		System.out.println(G7countries);
	}
	
//	public static class MyThread extends Thread{
//		@Override
//		public void run() {
//			System.out.println("MyThread is Running");
//		}
//	}
	
//	public static class MyThread implements Runnable{
//		@Override
//		public void run() {
//			System.out.print("Thread is Running");
//		}
//	}


}
