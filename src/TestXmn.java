
/**
 * 测试设置新生代大小的选项-Xmn
 *
 * @author zhangzhiwang
 * @date 2018年3月7日 下午11:02:16
 */
public class TestXmn {
	public static void main(String[] args) {
		byte[] b = null;
		for(int i = 0; i < 10; i++) {
			b = new byte[1 * 1024 * 1024];
		}
	}
}
