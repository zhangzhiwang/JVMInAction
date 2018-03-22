
/**
 * 测试jps命令
 * 
 * @author zhangzhiwang
 * @date 2018年3月22日 下午1:49:20
 */
public class TestJps {
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 1000000; i++) {
			byte[] b = new byte[10 * 1024 * 1024];
			Thread.sleep(1000);
		}
	}
}
