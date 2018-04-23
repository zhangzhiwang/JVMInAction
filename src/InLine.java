
/**
 * 方法内联
 * 
 * @author zhangzhiwang
 * @date 2018年4月19日 上午9:47:57
 */
public class InLine {
	private static int num;
	
	public static void met1() {
		num++;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 1000_0000; i++) {
			met1();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
