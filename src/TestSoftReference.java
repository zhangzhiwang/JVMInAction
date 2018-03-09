import java.lang.ref.SoftReference;

/**
 * 测试软引用
 * 
 * @author zhangzhiwang
 * @date 2018年3月9日 下午1:45:59
 */
public class TestSoftReference {
	public static void main(String[] args) {
		//使用-Xms10m -Xmx10m测试
		//强引用
		User u = new User(1, "aaa");
		//通过强引用创建软引用
		SoftReference<User> us = new SoftReference<User>(u);
		//去掉强引用
		u = null;
		System.out.println(us.get());
		System.gc();
		System.out.println("第一次垃圾回收之后：");
		System.out.println(us.get());
		
		byte[] b = new byte[7 * 991 * 1024];//当系统感知堆内存有压力之后会调用GC
		System.out.println("第二次GC之后：");
		System.out.println(us.get());
	}
}

class User {
	private int id;
	private String name;

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}