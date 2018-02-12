
/**
 * 变量名可以用任意Unicode字符命名，中文也属于Unicode字符
 *
 * @author zhangzhiwang
 * @date 2018年2月12日 下午8:20:33
 */
public class 测试 {
	private int 数量;
	private int i = 100_000;//jdk 1.7中允许用下划线分个数字以提高可读性
	private long l = 1000_00_00000L;
	
	public 测试() {
		super();
	}
	
	public void 方法() {}
	
	public static void main(String[] args) {
		System.out.println(10000_0);
	}
}
