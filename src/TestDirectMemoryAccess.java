import java.nio.ByteBuffer;

/**
 * 测试直接内存的访问速度
 * 
 * @author zhangzhiwang
 * @date 2018年3月8日 下午12:49:22
 */
public class TestDirectMemoryAccess {
	public static void main(String[] args) {
		//直接内存的访问（读写）速度要快于堆内存
		TestDirectMemoryAccess t = new TestDirectMemoryAccess();
		t.directAccess();
		t.bufferAccess();
		
		t.directAccess();
		t.bufferAccess();
	}
	
	public void directAccess() {
		long start = System.currentTimeMillis();
		ByteBuffer b = ByteBuffer.allocateDirect(500);
		for(int i = 0; i < 10_0000; i++) {
			for(int j = 0; j < 99; j++) {
				b.putInt(j);
			}
			b.flip();
			for(int j = 0; j < 99; j++) {
				b.getInt();
			}
			b.clear();
		}
		long end = System.currentTimeMillis();
		System.out.println("directAccess:" + (end - start));
	}
	
	public void bufferAccess() {
		long start = System.currentTimeMillis();
		ByteBuffer b = ByteBuffer.allocate(500);
		for(int i = 0; i < 10_0000; i++) {
			for(int j = 0; j < 99; j++) {
				b.putInt(j);
			}
			b.flip();
			for(int j = 0; j < 99; j++) {
				b.getInt();
			}
			b.clear();
		}
		long end = System.currentTimeMillis();
		System.out.println("bufferAccess:" + (end - start));
	}
}
