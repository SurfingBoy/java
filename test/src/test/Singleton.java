package test;

public class Singleton {
	//声明变量
	private static volatile Singleton singleton=null;
	
	//私有构造函数
	private Singleton() {}
	
	//提供对外方法
	public static Singleton getInstance() {
		//先检查实例是否存在，如果不存在进入下面的同步块
		if(singleton==null) {
			//同步块，线程安全地创建实例
			synchronized (Singleton.class) {
				//再次检查实例是否存在，如果不存在才真正创建实例
				if(singleton==null) {
					singleton=new Singleton();
				}
			}
		}
		return singleton;
	}
}


