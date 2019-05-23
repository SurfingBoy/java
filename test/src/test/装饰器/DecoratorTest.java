package test.装饰器;

public class DecoratorTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sourceable sourceable=new Source();
		Sourceable obj=new Decorator(sourceable);
		obj.method();
	}
}
