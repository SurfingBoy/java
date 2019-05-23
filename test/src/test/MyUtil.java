package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyUtil {
	private MyUtil() {
		throw new AssertionError();
	}
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) throws Exception{
		ByteArrayOutputStream bOutputStream=new ByteArrayOutputStream();
		ObjectOutputStream outputStream=new ObjectOutputStream(bOutputStream);
		outputStream.writeObject(obj);
		
		ByteArrayInputStream bInputStream=new ByteArrayInputStream(bOutputStream.toByteArray());
		ObjectInputStream oInputStream=new ObjectInputStream(bInputStream);
		return (T)oInputStream.readObject();
		//说明：调用  ByteArrayInputStream或  ByteArrayOutputStream对象的 close方法没有任何意义 
		//这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
	}
}
