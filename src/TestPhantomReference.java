import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 测试虚饮用
 *
 * @author zhangzhiwang
 * @date 2018年3月13日 下午10:16:28
 */
public class TestPhantomReference {
	private static TestPhantomReference testPhantomReference;
	private static ReferenceQueue<TestPhantomReference> referenceQueue;
	
	static class MonitorRefQueue extends Thread {
		@Override
		public void run() {
			while(true) {
				if(referenceQueue != null) {
					PhantomReference<TestPhantomReference> phantomReference = null;
					try {
						phantomReference = (PhantomReference<TestPhantomReference>) referenceQueue.remove();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					if(phantomReference != null) {
						System.out.println("GC回收虚引用对象");
					}
				}
			}
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("对象复活");
		testPhantomReference = this;
	}
	
	@Override
	public String toString() {
		return "TestPhantomReference.toString()";
	}
	
	public static void main(String[] args) throws InterruptedException {
		MonitorRefQueue monitorRefQueue = new MonitorRefQueue();
		monitorRefQueue.setDaemon(true);
		monitorRefQueue.start();
		
		testPhantomReference = new TestPhantomReference();
		referenceQueue = new ReferenceQueue<>();
		//通过强引用建立虚引用
		PhantomReference<TestPhantomReference> ph = new PhantomReference<TestPhantomReference>(testPhantomReference, referenceQueue);
		testPhantomReference = null;
		System.out.println("第一次GC");
		System.gc();
		Thread.sleep(1000);
		System.out.println(testPhantomReference == null);
		System.out.println("第二次GC");
		testPhantomReference = null;
		System.gc();
		Thread.sleep(1000);
		System.out.println(testPhantomReference == null);
	}
}
