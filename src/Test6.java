
/**
 * 测试jmc
 *
 * @author zhangzhiwang
 * @date 2018年3月25日 下午10:17:42
 */
public class Test6 {
	public static void main(String[] args) {
		new Test6_1().start();
		while(true) {}
	}
}

class Test6_1 extends Thread {
	@Override
	public void run() {
		while(true) {}
	}
}