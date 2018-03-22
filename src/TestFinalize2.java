
/**
 * 测试finalize()方法
 * 
 * @author zhangzhiwang
 * @date 2018年3月21日 上午10:46:28
 */
public class TestFinalize2 {
	public static void main(String[] args) throws Throwable {
		//finalize()方法默认由GC调用，也就是当发生GC时会自动调用finalize()方法而无需显示地调用，也就是什么时候发生GC什么时候会调用对象的finalize()方法；但是当程序中显示地去调用finalize()方法时，该方法会被立即调用而无需gc的发生，这也是为什么显示地调用finalize()方法的时候在没有发生gc的时候该方法也会被执行
		for(int i = 0; i < 3; i++) {
			TestFinalize2 t = new TestFinalize2();
//			t.finalize();
			System.gc();
		}
	}
	
	@Override
	protected void finalize() {
		System.out.println(this.toString() + "被回收！");
	}
}
