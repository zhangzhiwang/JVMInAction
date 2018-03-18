
/**
 * 测试eden区
 *
 * @author zhangzhiwang
 * @date 2018年3月18日 下午9:50:42
 */
public class TestEden {
	public static void main(String[] args) {
		//使用参数 -Xms64m -Xmx64m -XX:+PrintGCDetails
		//本例旨在证明如果不发生GC，那么新生对象都在Eden区
		for(int i = 0; i < 5 * 1024; i++) {
			byte[] b = new byte[1024];
		}
	}
}
