import java.util.List;
import java.util.Vector;

/**
 * 偏向锁
 * 
 * @author zhangzhiwang
 * @date 2018年4月8日 上午11:09:52
 */
public class Biased {
	private static List<Integer> list = new Vector<>();
	private static Biased b = new Biased();
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10_0000; i++) {
//			list.add(i);
			b.met1();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	public synchronized void met1() {
		byte[] b = new byte[1 * 1024 * 1024];
	} 
}
