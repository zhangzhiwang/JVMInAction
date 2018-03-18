
/**
 * 测试各种不同的垃圾回收器
 *
 * @author zhangzhiwang
 * @date 2018年3月14日 下午10:23:40
 */
public class TestGCs {
	public static void main(String[] args) {
		byte[] b = null;
		for(int i = 0; i < 10; i++) {
			b = new byte[10 * 1024 * 1024];
		}
		System.gc();
	}
}
