import java.util.HashMap;
import java.util.Map;

/**
 * 测试对象从新生代晋升到老年代
 * 
 * @author zhangzhiwang
 * @date 2018年3月20日 上午9:34:01
 */
public class TestObjFromNewToOld {
	public static void main(String[] args) {
		Map<Integer, byte[]> map = new HashMap<>();//保存5M对象不会回收	
		for(int i = 0; i < 5 * 1024; i++) {
			byte[] b = new byte[1024];
			map.put(i, b);
		}
		
		for(int i = 0; i < 17; i++) {//制造一些对象以引起GC
			for(int j = 0; j < 270; j++) {
				byte[] b = new byte[1024 * 1024];
			}
		}
	}
}
