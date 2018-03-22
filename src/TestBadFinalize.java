
/**
 * 糟糕的finalize()会影响GC性能，甚至会抛出OOM
 * 
 * @author zhangzhiwang
 * @date 2018年3月21日 下午4:56:59
 */
public class TestBadFinalize {
	private byte[] b = new byte[512];
	
	@Override
	protected void finalize() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			TestBadFinalize t = new TestBadFinalize();
//			Test1 t = new Test1();
		}
	}
}
