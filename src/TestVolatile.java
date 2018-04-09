
/**
 * 测试volatile
 *
 * @author zhangzhiwang
 * @date 2018年4月9日 上午11:30:14
 */
public class TestVolatile {
	private static long l;
	
	public static class WriteThread extends Thread {
		private long ll;

		public WriteThread(long ll) {
			super();
			this.ll = ll;
		}

		public WriteThread() {
			super();
		}
		
		@Override
		public void run() {
			while(true) {
				TestVolatile.l = ll;
				Thread.yield();
			}
		}
	}
	
	public static class ReadThread extends Thread {
		@Override
		public void run() {
			while(true) {
				long result = TestVolatile.l;
				if(result != 111L && result != -999L && result != 333L && result != -444L) {
					System.out.println("err:" + result);
				}
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
		new WriteThread(111L).start();
		new WriteThread(-999L).start();
		new WriteThread(333L).start();
		new WriteThread(-444L).start();
		new ReadThread().start();
	}
}
