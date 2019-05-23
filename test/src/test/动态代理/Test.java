package test.动态代理;

public class Test {
	public static void main(String[] args) {
		handlerOrder(new MaxOrderHandler(), "234243545454");
	}
	
	public static void handlerOrder(OrderHandler orderHandler,String orderId) {
		//创建处理器对象
		OrderHandlerProxy proxy=new OrderHandlerProxy();
		//实例化对象
		OrderHandler order=(OrderHandler) proxy.bind(orderHandler);
		
		order.handler(orderId);
		System.out.println(order.toString());
	}
}
