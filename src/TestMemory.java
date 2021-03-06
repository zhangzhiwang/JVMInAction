
/**
 * 内存测试
 *
 * @author zhangzhiwang
 * @date 2018年3月6日 下午10:51:41
 */
public class TestMemory {
	public static void main(String[] args) {
		System.out.println("系统初始：");
		System.out.println("最大可扩展堆内存：" + (Runtime.getRuntime().maxMemory()) + "M");
		System.out.println("实时可用堆内存：" + (Runtime.getRuntime().freeMemory()) + "M");
		System.out.println("实时总内存：" + (Runtime.getRuntime().totalMemory()) + "M");
		System.out.println("分配1M空间：");
		byte[] b = new byte[1 * 1024 * 1024];
		System.out.println("最大可扩展堆内存：" +(Runtime.getRuntime().maxMemory()) + "M");
		System.out.println("实时可用堆内存：" + (Runtime.getRuntime().freeMemory()) + "M");
		System.out.println("实时总内存：" + (Runtime.getRuntime().totalMemory()) + "M");
		System.out.println("分配4M空间：");
		b = new byte[4 * 1024 * 1024];
		System.gc();
		System.out.println("最大可扩展堆内存：" +(Runtime.getRuntime().maxMemory()) + "M");
		System.out.println("实时可用堆内存：" + (Runtime.getRuntime().freeMemory()) + "M");
		System.out.println("实时总内存：" + (Runtime.getRuntime().totalMemory()) + "M");
	}
}
