import java.util.Random;

/**
 * 测试BTrace
 * 
 * @author zhangzhiwang
 * @date 2018年3月25日 上午11:27:24
 */
public class BTrace {
	public static void main(String[] args) throws Exception {
		met1();
		while(true) {}
	}
	
	private static void met1() throws Exception {
		Thread.sleep(3000);
	}
}
