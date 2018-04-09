
/**
 * 可见性
 *
 * @author zhangzhiwang
 * @date 2018年4月9日 下午12:07:31
 */
public class TestVolatile2 {
	public static class MyThread extends Thread {
		private volatile boolean b;
		
		@Override
		public void run() {
			int i = 0;
			while(!b) {
				System.out.println(i++);
			}
			System.out.println("stopped");
		}
		
		public void stopMe() {
			b = true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		MyThread m = new MyThread();
		m.start();
		Thread.sleep(1000);
		m.stopMe();
		Thread.sleep(Integer.MAX_VALUE);
	}
}
