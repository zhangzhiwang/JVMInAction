
/**
 * 打印一个数值的二进制表示
 *
 * @author zhangzhiwang
 * @date 2018年2月26日 上午8:18:24
 */
public class Test1 {
	private byte[] b = new byte[512];
	public static void main(String[] args) {
//		printIntBinary(10);
		printFloatBinary(9.0f);
	}
	
	private static void printIntBinary(int num) {
		for(int i = 0; i < 32; i++) {
			int t = (num & 0x80000000 >>> i) >>> (31 - i);
			System.out.print(t);
		}
	}
	
	private static void printFloatBinary(float f) {
		int i = Float.floatToRawIntBits(f);
		String s = Integer.toBinaryString(i);
		System.out.println(s);
	}
	
	@Override
	protected void finalize() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
