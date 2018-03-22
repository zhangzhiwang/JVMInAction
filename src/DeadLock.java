
/**
 * 模拟死锁
 * 
 * @author zhangzhiwang
 * @date 2018年3月22日 下午8:27:25
 */
public class DeadLock {
	private static Object obj1 = new Object();
	private static Object obj2 = new Object();
	
	static class MyThread1 extends Thread {
		@Override
		public void run() {
			synchronized(obj1) {
				for(int i = 0; i < Integer.MAX_VALUE; i++) {
					byte[] b = new byte[1];
				}
				synchronized(obj2) {
					
				}
			}
		}
	}
	
	static class MyThread2 extends Thread {
		@Override
		public void run() {
			synchronized(obj2) {
				for(int i = 0; i < Integer.MAX_VALUE; i++) {
					byte[] b = new byte[1];
				}
				synchronized(obj1) {
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MyThread1 m1 = new MyThread1();
		m1.setName("MMMMMMMM1");
		m1.start();
		
		MyThread2 m2 = new MyThread2();
		m2.setName("mmmmmmmmmm2");
		m2.start();
	}
}
