package test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<Integer, User> users=new HashMap<Integer, User>();
		users.put(6, new User("张飒", 12));
		users.put(2, new User("王五", 23));
		users.put(3, new User("李四", 4));
		users.put(4, new User("问问", 12));
		System.out.println(users);
		//排序之后
		System.out.println(sortHashMap(users));
	}
	public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map){
		//获取map的键值对集合
		Set<Entry<Integer, User>> entrySet=map.entrySet();
		
		//将set集合转为list集合，调用工具类的排序方法
		List<Entry<Integer, User>> list=new ArrayList<Entry<Integer,User>>(entrySet);
		Collections.sort(list, new Comparator<Entry<Integer, User>>() {
			//安装age降序排列
			@Override
			public int compare(Entry<Integer, User> o1, Entry<Integer, User> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().getAge()-o2.getValue().getAge();
			}
		});
		//用一个有序的HashMap来收集
		LinkedHashMap<Integer, User> linkedHashMap=new LinkedHashMap<Integer, User>();
		for(Entry<Integer, User> entry:list) {
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		//返回结果
		return linkedHashMap;
	}
}
