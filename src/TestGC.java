
/**
 * GC测试
 * 
 * @author zhangzhiwang
 * @date 2018年2月28日 下午2:30:09
 */
public class TestGC {
	public static void main(String[] args) {
		byte[] b = new byte[2 * 1024 * 1024];
		b = null;
		System.gc();
	}
}
