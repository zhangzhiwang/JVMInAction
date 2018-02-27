
/**
 * 方法的参数和局部变量保存在栈桢的局部变量表里面
 * 
 * @author zhangzhiwang
 * @date 2018年2月26日 下午3:10:55
 */
public class TestStackOverFlow2 {
	private static int num;

	private static void deepLoop(int i, long l, float f) {
		int i1 = 1;
		int i2 = 1;
		int i3 = 1;
		int i4 = 1;
		int i5 = 1;
		int i6 = 1;
		int i7 = 1;
		int i8 = 1;

		num++;
		deepLoop(i8, l, f);
	}

	private static void deepLoop() {
		num++;
		deepLoop();
	}

	public static void main(String[] args) {
		// 在Java栈大小相同的情况下，方法的局部变量（包括参数）越少，嵌套调用的层次越深。因为局部变量保存在局部变量表里面，变量越少所占用的栈桢空间越少，相同栈大小的情况下能容纳的栈桢个数就会增多，而一栈桢被压入栈就代表一次方法的调用
		try {
//			deepLoop();
			deepLoop(1, 1, 1);
		} catch (Throwable e) {
			System.out.println("调用深度num = " + num);
			e.printStackTrace();
		}
	}
}
