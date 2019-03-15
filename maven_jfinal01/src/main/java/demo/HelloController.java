package demo;

import com.jfinal.core.Controller;

public class HelloController extends Controller{
	public void index() {
		renderText("Hello World");
	}
	public void getName() {
		renderText("JFinal");
	}
}
