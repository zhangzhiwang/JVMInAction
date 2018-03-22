
/**
 * 测试GC
 *
 * @author zhangzhiwang
 * @date 2018年3月18日 下午10:50:49
 */
public class TestGC3 {
	public static void main(String[] args) {
		met1();
	}

	public static void met1() {
		{
			byte[] b1 = new byte[1 * 1024 * 1024];
			byte[] b2 = new byte[1 * 1024 * 1024];
			byte[] b3 = new byte[1 * 1024 * 1024];
			byte[] b4 = new byte[1 * 1024 * 1024];
			byte[] b5 = new byte[1 * 1024 * 1024];
			byte[] b6 = new byte[1 * 1024 * 1024];
			byte[] b7 = new byte[1 * 1024 * 1024];
			byte[] b8 = new byte[1 * 1024 * 1024];
			byte[] b9 = new byte[1 * 1024 * 1024];
			byte[] b10 = new byte[1 * 1024 * 1024];
		}
		System.gc();
	}

	public void met5() {
		{
			byte[] b1 = new byte[1 * 1024 * 1024];
			byte[] b2 = new byte[1 * 1024 * 1024];
			byte[] b3 = new byte[1 * 1024 * 1024];
			byte[] b4 = new byte[1 * 1024 * 1024];
			byte[] b5 = new byte[1 * 1024 * 1024];
			byte[] b6 = new byte[1 * 1024 * 1024];
			byte[] b7 = new byte[1 * 1024 * 1024];
			byte[] b8 = new byte[1 * 1024 * 1024];
			byte[] b9 = new byte[1 * 1024 * 1024];
			byte[] b10 = new byte[1 * 1024 * 1024];
		}
		// String s1 = "";
		// String s2 = "";
		// String s3 = "";
		// String s4 = "";
		// String s5 = "";
		// String s6 = "";
		// String s7 = "";
		// String s8 = "";
		// String s9 = "";
		// String s10 = "";
		byte[] b1 = new byte[1 * 1024 * 1024];
		byte[] b2 = new byte[1 * 1024 * 1024];
		byte[] b3 = new byte[1 * 1024 * 1024];
		byte[] b4 = new byte[1 * 1024 * 1024];
		byte[] b5 = new byte[1 * 1024 * 1024];
		byte[] b6 = new byte[1 * 1024 * 1024];
		byte[] b7 = new byte[1 * 1024 * 1024];
		byte[] b8 = new byte[1 * 1024 * 1024];
		byte[] b9 = new byte[1 * 1024 * 1024];
		byte[] b10 = new byte[1 * 1024 * 1024];
		// 按照书中
		System.gc();
	}

	public static void met2() {
		for (int i = 0; i < 10; i++) {
			if (i < 5) {
				byte[] b = new byte[1 * 1024 * 1024];// 按照书中p123第二段的说法：循环中创建的对象如果没有被其他地方所引用那么在下次循环的时候由于失去了作用域，该对象失去引用，可被回收
			} else {
				String s = "";
			}
		}
		System.gc();
	}

	public static void met3() {
		byte[] b = null;
		for (int i = 0; i < 10; i++) {
			b = new byte[1 * 1024 * 1024];
		}
		System.gc();
	}

	public static void met4() {
		for (int i = 0; i < 10; i++) {
			byte[] b = new byte[1 * 1024 * 1024];//为什么下一次循环会将上一次循环创建的对象的引用断开，通过实际的测试，编译后查看class文件，这种现象和met5()方法的槽位复用很类似。
												//所以解释在循环中创建对象——在某次循环创建的对象，在下一次循环中该对象失去了引用，不是因为上一次循环创建的对象失去了作用域，而是在下一次循环的时候进行了槽位复用，复用了上一次循环变量的槽位，因为当对象超过作用域后如果没有失去引用（置为null）、槽位复用和逃逸那么对象将不会失去引用，也不会被回收
		}
		System.gc();
	}
}
