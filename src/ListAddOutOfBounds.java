import java.util.ArrayList;
import java.util.List;

/**
 * 模拟多线程在向ArrayList添加元素时抛数组下标越界
 * 
 * @author zhangzhiwang
 * @date 2018年4月8日 上午10:23:54
 */
public class ListAddOutOfBounds {
	private static List<Integer> list = new ArrayList<>();

	public static class MyThread extends Thread {
		private int num;

		public MyThread(int num) {
			super();
			this.num = num;
		}

		public MyThread() {
			super();
		}

		@Override
		public void run() {
			for (int i = 0; i < 100_0000; i++) {
				list.add(num);
				System.out.println(this.getName() + " added " + num);
				num += 2;
			}
		}
	}

	public static void main(String[] args) {
		//多线程在向ArrayList添加元素时有可能出现数组下标越界
//		MyThread m1 = new MyThread(0);
//		m1.setName("Thread-1");
//		MyThread m2 = new MyThread(1);
//		m2.setName("Thread-2");
//		m1.start();
//		m2.start();
		for(int i = 0; i < 10; i++) {
			MyThread m = new MyThread(i);
			m.setName("Thread-" + i);
			m.start();
		}
	}
}
