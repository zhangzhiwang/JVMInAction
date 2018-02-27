
/**
 * 局部变量对垃圾回收的影响
 * 
 * @author zhangzhiwang
 * @date 2018年2月26日 下午5:16:27
 */
public class Test5 {
	private static void met1() {
		byte[] b = new byte[5 * 1024 * 1024];
		System.gc();
	}

	private static void met2() {
		byte[] b = new byte[5 * 1024 * 1024];
		b = null;
		System.gc();
	}

	private static void met3() {
		{
			byte[] b = new byte[5 * 1024 * 1024];
		}
		System.gc();
	}

	private static void met4() {
		{
			byte[] b = new byte[5 * 1024 * 1024];
		}
		int c = 1;
		System.gc();
	}

	private static void met5() {
		met1();
		System.gc();
	}

	public static void main(String[] args) {
		// 只要被局部变量表中的变量引用的对象都不会被回收
		met1();
//		met2();
//		met3();
//		met4();
//		met5();
	}
}
