
/**
 * 测试TLAB
 *
 * @author zhangzhiwang
 * @date 2018年3月19日 上午8:00:03
 */
public class TestTLAB {
	public static void main(String[] args) {
		//使用参数运行java -XX:-UseTLAB -Xcomp -XX:-BackgroundCompilation -XX:-DoEscapeAnalysis -server
		long start = System.currentTimeMillis();
		for(int i = 0; i < 1000_0000; i++) {
			allocate();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	public static void allocate() {
		byte[] b = new byte[2];
		b[0] = 1;
	}
}
