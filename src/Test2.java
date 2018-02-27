
/**
 * 用java命令给main方法传入参数
 * 
 * @author zhangzhiwang
 * @date 2018年2月26日 下午12:27:48
 */
public class Test2 {
	public static void main(String[] args) {
		for(int i = 1; i <= args.length; i++) {
			System.out.println("第" + i + "个参数：" + args[i - 1]);
		}
		System.out.println("----------------");
		System.out.println("最大堆内存为：" + Runtime.getRuntime().maxMemory() + "bytes，合" + (Runtime.getRuntime().maxMemory() / 1024 / 1024) + "M");
	}
}
