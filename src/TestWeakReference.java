import java.lang.ref.WeakReference;

/**
 * 测试弱引用
 * 
 * @author zhangzhiwang
 * @date 2018年3月13日 下午1:29:12
 */
public class TestWeakReference {
	public static void main(String[] args) {
		//强引用
		User user = new User(1, "aaa");
		//通过强引用建立弱引用
		WeakReference<User> weakReference = new WeakReference<User>(user);
		//去掉强引用
		user = null;
		System.out.println(weakReference.get());
		System.gc();
		System.out.println(weakReference.get());//弱引用是比软引用更弱的一种引用类型，JVM一旦发现弱引用不管堆内存是否有压力直接将其回收
	}
}
