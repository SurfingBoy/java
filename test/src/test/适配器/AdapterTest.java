package test.适配器;

public class AdapterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Source source=new Source();
		Targetable targetable=new Adapter(source);
		targetable.method1();
		targetable.method2();
	}

}
