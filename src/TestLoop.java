
/**
 * 测试循环内创建对象
 * 
 * @author zhangzhiwang
 * @date 2018年3月22日 上午9:46:52
 */
public class TestLoop {
	public static void met1() {
		if(true) {
			byte[] b = new byte[10 * 1024 * 1024];
		}
		System.gc();
	}
	
	public static void met2() {
		for(int i = 0; i < 1; i++) {
			byte[] b = new byte[10 * 1024 * 1024];
		}
		System.gc();
	}
}
