
/**
 * 指令重排
 *
 * @author zhangzhiwang
 * @date 2018年4月9日 上午11:54:25
 */
public class OrderExample extends Thread {
	private int i;
	private boolean b;
	
	public void met1() {
		b = true;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.yield();
		i = 1;
	}
	
	public void met2() {
		if(b) {
			int a = i + 1;
			if(a != 2) {
				System.out.println("a = " + a);
			}
		}
	}
	
	@Override
	public void run() {
		met1();
		met2();
	}
	
	public static void main(String[] args) {
		while(true) {
			new OrderExample().start();;
		}
	}
}
