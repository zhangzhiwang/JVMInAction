
/**
 * 测试jps命令
 * 
 * @author zhangzhiwang
 * @date 2018年3月22日 下午1:49:20
 */
public class TestJps {
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		MyClassLoader loader1 = new MyClassLoader("loader1", "/Users/zhangzhiwang/Documents/jvm_in_action/");
		Class c = loader1.loadClass("Test1");
		Test1 t = (Test1) c.newInstance();
		for(int i = 0; i < 1000000; i++) {
			byte[] b = new byte[10 * 1024 * 1024];
			System.gc();
			Thread.sleep(1000);
		}
	}
}
