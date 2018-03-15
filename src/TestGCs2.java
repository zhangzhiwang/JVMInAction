
/**
 * 测试各种垃圾回收器
 * 
 * @author zhangzhiwang
 * @date 2018年3月15日 下午12:38:51
 */
public class TestGCs2 {
	public static void main(String[] args) {
		byte[] b = null;
		for(int i = 0; i < 10; i++) {
			b = new byte[3 * 1024 * 1024];
		}
		System.gc();
	}
}
