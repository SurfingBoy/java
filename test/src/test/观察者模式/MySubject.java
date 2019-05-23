package test.观察者模式;

public class MySubject extends AbstractSubject{
	@Override
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("update myself");
		notifyObservers();
	}
}
