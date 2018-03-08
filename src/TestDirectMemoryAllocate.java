import java.nio.ByteBuffer;

/**
 * 测试直接内存的申请速度
 * 
 * @author zhangzhiwang
 * @date 2018年3月8日 下午12:38:09
 */
public class TestDirectMemoryAllocate {
	public static void main(String[] args) {
		//内存申请时堆内存要快于直接内存
		TestDirectMemoryAllocate t = new TestDirectMemoryAllocate();
		t.directAllocate();
		t.bufferAllocate();
		
		t.directAllocate();
		t.bufferAllocate();
	}
	
	public void directAllocate() {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 20_0000; i++) {
			ByteBuffer b = ByteBuffer.allocateDirect(1000);
		}
		long end = System.currentTimeMillis();
		System.out.println("directAllocate:" + (end - start));
	}
	
	public void bufferAllocate() {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 20_0000; i++) {
			ByteBuffer b = ByteBuffer.allocate(1000);
		}
		long end = System.currentTimeMillis();
		System.out.println("bufferAllocate:" + (end - start));
	}
}
