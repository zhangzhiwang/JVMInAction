
/**
 * 测试finalize()方法
 * 
 * @author zhangzhiwang
 * @date 2018年3月21日 上午10:42:29
 */
public class TestFinalize {
	public static void main(String[] args) {
		TestFinalize t = new TestFinalize();
		System.out.println("I am " + t.toString());
		t = null;
		System.gc();//在垃圾回收时会调用对象的finalize()方法
	}
	
	@Override
	protected void finalize() {
		System.out.println(this.toString() + " goint to die!");
	}
}
