
/**
 * 用递归算法编写一段程序，使之产生StackOverflowError，在出现内存溢出时打印出递归调用深度
 * 
 * @author zhangzhiwang
 * @date 2018年2月26日 下午2:17:55
 */
public class TestStackOverFlow {
	private static int num;

	public static void main(String[] args) {
		try {
			deepLoop(1l, new Test1());
		} catch (Throwable e) {// 注意：这里捕获的是Throwable而不是Exception
			System.out.println("递归深度num = " + num);
			e.printStackTrace();
		}
	}

	private static void deepLoop(long l, Test1 t1) {
		int i1 = 1;
		int i2 = 1;
		int i3 = 1;
		int i4 = 1;
		int i5 = 1;
		int i6 = 1;
		int i7 = 1;
		int i8 = 1;
		int i9 = 1;
		double i10 = 1;
		TestStackOverFlow t = new TestStackOverFlow();
		num++;
		deepLoop(1l, t1);
	}
}
