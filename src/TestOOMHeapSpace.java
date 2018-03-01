
/**
 * 测试堆溢出
 * 
 * @author zhangzhiwang
 * @date 2018年2月28日 下午1:21:13
 */
public class TestOOMHeapSpace {
	public static void main(String[] args) {
		int i = 0;
		try {
			for(i = 0; i < 1000000; i++) {
				byte[] b = new byte[5 * 1024 * 1024];
			}
		} catch (Throwable e) {
			System.out.println("堆溢出");
			System.out.println("共创建对象：" + i);
			e.printStackTrace();
		}
	}
}
