package test.动态代理;

public class NormalOrderHandler implements OrderHandler{

	@Override
	public void handler(String orderId) {
		// TODO Auto-generated method stub
		System.out.println("NormalOrder,orderId="+orderId);
	}

}
