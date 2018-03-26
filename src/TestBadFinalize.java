import java.util.Random;

/**
 * 糟糕的finalize()会影响GC性能，甚至会抛出OOM
 * 
 * @author zhangzhiwang
 * @date 2018年3月21日 下午4:56:59
 */
public class TestBadFinalize extends Thread {
	private byte[] b = new byte[512];

	@Override
	protected void finalize() {
		try {
			// Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestBadFinalize t1 = new TestBadFinalize();
		t1.setName("aaa");
		t1.start();

		TestBadFinalize t2 = new TestBadFinalize();
		t2.setName("bbb");
		t2.start();

		for (int i = 0; i < 100_0000; i++) {
			byte[] b = new byte[1 * 1024 * 1024];
			// Test1 t = new Test1();
			// System.gc();
		}
		String s1 = "asdasdasd";
		String s2 = new String("123321");
		met1();
	}

	@Override
	public void run() {
		while (true) {

		}
	}

	/**
	 * 目的：占用大量CPU时间
	 * 
	 * @author zhangzhiwang
	 * @date 2018年3月25日 上午10:46:59
	 */
	private static void met1() {
		for (int j = 0; j < 100_0000; j++) {
			int i = new Random(Long.MAX_VALUE).nextInt(Integer.MAX_VALUE);
			double d = Double.MAX_VALUE / i;
		}
	}
}
