
/**
 * 创建过多的线程导致内存溢出
 * 
 * @author zhangzhiwang
 * @date 2018年3月26日 上午10:46:44
 */
public class CreateLotsOfThreads extends Thread {
	public static void main(String[] args) {
		//Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			System.out.println(i);
			CreateLotsOfThreads c = new CreateLotsOfThreads();
			c.setName("CreateLotsOfThreads_" + i);
			c.start();
		}
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
