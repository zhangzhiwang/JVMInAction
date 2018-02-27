
/**
 * 用jclasslib查看class的局部变量表
 * 
 * @author zhangzhiwang
 * @date 2018年2月26日 下午4:20:17
 */
public class Test3 {
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
		num++;
		System.out.println(i1);
		deepLoop(1l, t1);
	}
}
