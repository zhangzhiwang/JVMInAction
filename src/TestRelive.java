
/**
 * 测试对象复活
 * 
 * @author zhangzhiwang
 * @date 2018年3月9日 下午12:25:17
 */
public class TestRelive {
	private static TestRelive testRelive;
	
	public static void main(String[] args) throws InterruptedException {
		testRelive = new TestRelive();
		testRelive = null;
		System.gc();
		Thread.sleep(1);
		System.out.println(testRelive == null);
		System.out.println("----------------");
		
		testRelive = null;
		System.gc();
		Thread.sleep(1000);
		System.out.println(testRelive == null);
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("调用了finalize()方法");
		testRelive = this;
	}
}
