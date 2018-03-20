import java.util.HashMap;
import java.util.Map;

/**
 * 测试PretenureSizeThreshold
 * 
 * @author zhangzhiwang
 * @date 2018年3月20日 下午1:14:27
 */
public class TestPretenureSizeThreshold {
	public static void main(String[] args) {
		//PretenureSizeThreshold用来设定当对象的大小达到多少时直接放到老年代
//		Map<Integer, byte[]> map = new HashMap<>();//保存5M对象不会回收	
//		for(int i = 0; i < 5 * 1024; i++) {
//			byte[] b = new byte[1024];
//			map.put(i, b);
//		}
		
		byte[] b = new byte[2 * 1024 * 1024];
	}
}
