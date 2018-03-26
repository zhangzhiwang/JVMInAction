import java.nio.ByteBuffer;

/**
 * 模拟直接内存溢出
 * 
 * @author zhangzhiwang
 * @date 2018年3月26日 上午10:11:14
 */
public class DirectMemory {
	public static void main(String[] args) {
		//Java NIO会使用直接内存，通过-XX:MaxDirectMemorySize来制定直接内存大小
		for(int i = 0; i < 1024; i++) {
			ByteBuffer.allocateDirect(1024 * 1024);
			System.out.println(i);
		}
	}
}
