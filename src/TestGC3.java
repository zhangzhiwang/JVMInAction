
/**
 * 测试GC
 *
 * @author zhangzhiwang
 * @date 2018年3月18日 下午10:50:49
 */
public class TestGC3 {
	public static void main(String[] args) {
		met1();
	}
	
	public static void met1() {
		{
			byte[] b1 = new byte[1 * 1024 * 1024];
			byte[] b2 = new byte[1 * 1024 * 1024];
			byte[] b3 = new byte[1 * 1024 * 1024];
			byte[] b4 = new byte[1 * 1024 * 1024];
			byte[] b5 = new byte[1 * 1024 * 1024];
			byte[] b6 = new byte[1 * 1024 * 1024];
			byte[] b7 = new byte[1 * 1024 * 1024];
			byte[] b8 = new byte[1 * 1024 * 1024];
			byte[] b9 = new byte[1 * 1024 * 1024];
			byte[] b10 = new byte[1 * 1024 * 1024];
		}
		System.gc();
	}
	
	public static void met2() {
		for(int i = 0; i < 10; i++) {
			byte[] b = new byte[1 * 1024 * 1024];
		}
		System.gc();
	}
	
	public static void met3() {
		byte[] b = null;
		for(int i = 0; i < 10; i++) {
			b = new byte[1 * 1024 * 1024];
		}
		System.gc();
	}
}
