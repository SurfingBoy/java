package test.适配器;

public class Adapter implements Targetable{

	private Source source;
	
	public Adapter(Source source) {
		super();
		this.source=source;
	}
	
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("这是Targetable的方法");
	}
	
	public void method1() {
		source.method1();
	}
}
