
/**
 * 类初始化的死锁
 * 
 * @author zhangzhiwang
 * @date 2018年4月16日 下午12:43:00
 */
public class InitDeadLock extends Thread {
	private String flag;

	public InitDeadLock() {
		super();
	}

	public InitDeadLock(String flag) {
		super();
		this.flag = flag;
		this.setName("Thread" + flag);
	}

	@Override
	public void run() {
		try {
			Class.forName("Static" + flag);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(getName() + " is over.");
	}
	
	public static void main(String[] args) {
		InitDeadLock i1 = new InitDeadLock("A");
		i1.start();
		InitDeadLock i2 = new InitDeadLock("B");
		i2.start();
	}
}

class StaticA {
	//由于类存在静态变量（非final常量）或者静态语句块，所以在编译时编译器会生成<clinit>函数用于类的初始化，该函数时线程安全的，即加了锁，所以可能会在类舒适话的时候导致线程死锁
	static {
		try {
			Thread.sleep(1000);
			Class.forName("StaticB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class StaticB {
	static {
		try {
			Thread.sleep(1000);
			Class.forName("StaticA");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}