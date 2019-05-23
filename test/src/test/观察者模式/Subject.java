package test.观察者模式;

public interface Subject {
	//添加观察者
	public void add(Observer observer);
	
	//删除观察者
	public void del(Observer observer);
	
	//通知所有观察者
	public void notifyObservers();
	
	//自身的操作
	public void operation() ;
}
