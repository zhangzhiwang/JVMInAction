import java.util.HashMap;
import java.util.Map;

/**
 * 测试Stop The World
 * 
 * @author zhangzhiwang
 * @date 2018年3月14日 下午1:09:06
 */
public class TestSTW {
	/**
	 * 打印线程类
	 * 
	 * @author zhangzhiwang
	 * @date 2018年3月14日 下午1:10:50
	 */
	static class PrintThread extends Thread {
		private long start = System.currentTimeMillis();
		
		@Override
		public void run() {
			while(true) {
				long time = System.currentTimeMillis() - start;
				System.out.println(time/1000 + "." + (time%1000));//每隔0.1s打印一下距启动的时间偏移
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 自定义线程类
	 * 
	 * @author zhangzhiwang
	 * @date 2018年3月14日 下午1:17:11
	 */
	static class MyThread extends Thread {
		private Map<Long, byte[]> map = new HashMap<>();
		
		@Override
		public void run() {
			while(true) {
				if(map.size() * 512 / 1024 / 1024 >= 900) {
					map.clear();
					System.out.println("map is cleaned!");
				}
				
				byte[] b = null;
				for(int i = 0; i < 100; i++) {
					b = new byte[512];
					map.put(System.nanoTime(), b);
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		PrintThread printThread = new PrintThread();
		printThread.start();
		
		MyThread myThread = new MyThread();
		myThread.start();
	}
}
