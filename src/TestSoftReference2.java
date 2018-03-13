import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 测试软引用
 * 
 * @author zhangzhiwang
 * @date 2018年3月13日 下午12:28:55
 */
public class TestSoftReference2 {
	private static ReferenceQueue<User> referenceQueue;

	/**
	 * 监视引用队列
	 * 
	 * @author zhangzhiwang
	 * @date 2018年3月13日 下午12:37:19
	 */
	static class MonitorRefQueue extends Thread {
		@Override
		public void run() {
			while (true) {
				if (referenceQueue != null) {
					MySoftReference mySoftReferencce = null;
					try {
						mySoftReferencce = (MySoftReference) referenceQueue.remove();// 向下转型
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (mySoftReferencce != null) {
						System.out.println("对象" + mySoftReferencce.getUid() + "被回收");
					}
				}
			}
		}
	}

	/**
	 * 自定义软引用，用于标识被回收的强引用对象
	 * 
	 * @author zhangzhiwang
	 * @date 2018年3月13日 下午12:47:17
	 */
	static class MySoftReference extends SoftReference<User> {
		private int uid;

		public MySoftReference(User referent, ReferenceQueue<? super User> q) {
			super(referent, q);
			uid = referent.getId();
		}

		public MySoftReference(User referent) {
			super(referent);
		}

		public int getUid() {
			return uid;
		}

		public void setUid(int uid) {
			this.uid = uid;
		}

	}
	
	public static void main(String[] args) {
		//启动监控引用队列的线程
		MonitorRefQueue monitorRefQueue = new MonitorRefQueue();
		monitorRefQueue.setDaemon(true);
		monitorRefQueue.start();
		
		//强引用
		User user = new User(1, "aaa");
		
		//用强引用建立弱引用
		referenceQueue = new ReferenceQueue<User>();
		MySoftReference mySoftReference = new MySoftReference(user, referenceQueue);//当JVM感到堆内存压力时会进行GC，在回收软引用之前，会先将软引用放到引用队列里面，所以引用队列里面的元素不是手动填进去的
		//失去强引用
		user = null;
		System.out.println(mySoftReference.get());
		System.gc();
		System.out.println("After GC:");
		System.out.println(mySoftReference.get());
		
		//耗尽内存，使JVM感觉堆内存紧张
		byte[] b = new byte[7 * 991 * 1024];
		System.out.println("当JVM感到堆内存紧张后会进行垃圾回收");
		System.out.println(mySoftReference.get());
	}
}
