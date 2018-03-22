import java.util.HashMap;
import java.util.Map;

/**
 * 测试最大晋升老年代的阈值
 *
 * @author zhangzhiwang
 * @date 2018年3月18日 下午10:26:19
 */
public class TestMaxTenuringThreshold {
	public static void main(String[] args) {
		Map<Integer, byte[]> map = new HashMap<>();// map是为了将这5M的对象保存起来而不被垃圾回收
		for (int i = 0; i < 5 * 1024; i++) {
			byte[] b = new byte[5 * 1024];
			map.put(i, b);
		}

		// 继续产生对象以引起GC
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 270; j++) {
				byte[] b = new byte[1 * 1024 * 1024];
			}
		}
		System.out.println("-----------运行完毕！");
	}
}