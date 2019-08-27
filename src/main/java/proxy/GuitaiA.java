package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GuitaiA implements InvocationHandler {
	
	private Object pinPai;
	
	
	public GuitaiA(Object pinPai) {
		this.pinPai = pinPai;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("销售开始  柜台是： "+this.getClass().getSimpleName());
		method.invoke(pinPai, args);
		System.out.println("销售结束");
		return null;
	}

}