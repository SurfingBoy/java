package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class collectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Collection collection=new ArrayList();
//		collection.add("Hello");
//		collection.add("world");
//		collection.add("哈哈哈");
//		
//		Object[] xList= collection.toArray();
//		for(int i=0;i<xList.length;i++) {
//			System.out.println(xList[i]);
//		}
//		for(Object x:collection) {
//			System.out.println("1"+x);
//		}
//		Iterator iterator=collection.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		
		HashSet<Integer> hashSet=new HashSet<Integer>();
		Random random=new Random();
		while(hashSet.size()<5) {
			hashSet.add(random.nextInt(20)+1);
		}
		System.out.println(hashSet);
	}

}
