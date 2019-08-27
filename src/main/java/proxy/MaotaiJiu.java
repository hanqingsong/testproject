package proxy;

public class MaotaiJiu implements SellWine {

	@Override
	public void mainJiu() {
		// TODO Auto-generated method stub
		System.out.println("我卖得是茅台酒。");
		this.method2();
	}

	public void method2(){
		System.out.println("method2 this： "+this.getClass().getSimpleName());
	}

}