
/**
 * 测试并行回收器在进行FullGC前会先进行一次新生代的GC
 *
 * @author zhangzhiwang
 * @date 2018年3月18日 下午9:33:44
 */
public class TestGC2 {
	public static void main(String[] args) {
		System.gc();
	}
}
