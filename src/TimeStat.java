
/**
 * 耗时统计类
 * 
 * @author zhangzhiwang
 * @date 2018年4月18日 下午12:58:16
 */
public class TimeStat {
	static ThreadLocal<Long> t = new ThreadLocal<>();
	public static void start() {
		t.set(System.currentTimeMillis());
	}
	
	public static void end() {
		long end = System.currentTimeMillis();
		System.out.print(Thread.currentThread().getStackTrace()[2] + "spent : " + (end - t.get()));
	}
}
