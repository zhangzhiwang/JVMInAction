
/**
 * 对比解释运行和编译运行模式的执行效率
 * 
 * @author zhangzhiwang
 * @date 2018年4月18日 下午8:11:59
 */
public class InterpretedMode {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i = 0;i < 100_0000; i++) {
			met1();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	public static void met1() {
		Double d = Math.PI * Math.PI;
	}
}
