
/**
 * 测试GC
 * 
 * @author zhangzhiwang
 * @date 2018年3月19日 下午1:39:22
 */
public class TestGC4 {
	public static void main(String[] args) {
		
	}
	
	public static void met1() {
		{
			byte[] b1 = new byte[10 * 1024 * 1024];
		}
		System.gc();
	}
	
	public static void met4() {
		for(int i = 0; i < 1; i++) {
			if(i == 0) {
				byte[] b = new byte[10 * 1024 * 1024];
			}
		}
		System.gc();
	}
}
