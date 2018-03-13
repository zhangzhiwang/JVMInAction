import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 测试弱引用
 * 
 * @author zhangzhiwang
 * @date 2018年3月13日 下午1:43:00
 */
public class TestWeakReference2 {
	private static ReferenceQueue<User> referenceQueue;

	/**
	 * 监视引用队列
	 * 
	 * @author zhangzhiwang
	 * @date 2018年3月13日 下午1:44:16
	 */
	static class MonitorrRefQueue extends Thread {
		@Override
		public void run() {
			while (true) {
				if (referenceQueue != null) {
					MyWeakReference myWeakReference = null;
					try {
						myWeakReference = (MyWeakReference) referenceQueue.remove();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("对象" + myWeakReference.getUid() + "被回收");
				}
			}
		}
	}

	/**
	 * 自定义弱引用
	 * 
	 * @author zhangzhiwang
	 * @date 2018年3月13日 下午1:46:04
	 */
	static class MyWeakReference extends WeakReference<User> {
		private int uid;

		public MyWeakReference(User referent, ReferenceQueue<? super User> q) {
			super(referent, q);
			uid = referent.getId();
		}

		public int getUid() {
			return uid;
		}

		public void setUid(int uid) {
			this.uid = uid;
		}
	}
	
	public static void main(String[] args) {
		MonitorrRefQueue monitorrRefQueue = new MonitorrRefQueue();
		monitorrRefQueue.setDaemon(true);
		monitorrRefQueue.start();
		
		User user = new User(1, "aaa");
		referenceQueue = new ReferenceQueue<>();
		MyWeakReference myWeakReference = new MyWeakReference(user, referenceQueue);
		user = null;
		System.out.println(myWeakReference.get());
		System.gc();
		System.out.println("After GC:");
		System.out.println(myWeakReference.get());
	}
}
