
/**
 * 测试在循环里new对象
 *
 * @author zhangzhiwang
 * @date 2018年3月21日 下午10:30:54
 */
public class TestNewObjInLoop {
	public static void main(String[] args) {
	}

	public static void met1() {
		for (int i = 0; i < 1; i++) {
			byte[] b = new byte[1 * 1024 * 1024];
		}
		System.gc();
	}

	public static void met2() {
		if (true) {
			byte[] b = new byte[10 * 1024 * 1024];
		}
		System.gc();
	}
}
