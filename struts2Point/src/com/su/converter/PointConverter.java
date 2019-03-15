package com.su.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.su.model.Point;

/**
   *     自定义类型转换
 * @author Administrator
 *
 */
public class PointConverter extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		//将String转换为指定的类型
		String value =arg1[0];
		Point point=new Point(); 
		point.setX(value.substring(1, value.indexOf(",")));
		point.setY(value.substring(value.indexOf(",")+1,value.length()-1));
		return point;
	}

	/**
	 * 使用ognl表达式获取值时会调用改方法
	 */
	@Override
	public String convertToString(Map arg0, Object arg1) {
		//将指定类型转换为String
		Point point=(Point)arg1;
		return ("("+point.getX()+","+point.getY()+")");
	}

}
