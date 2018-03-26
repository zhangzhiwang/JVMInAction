
/**
 * 模拟堆溢出
 * 
 * @author zhangzhiwang
 * @date 2018年3月26日 上午10:04:21
 */
public class HeapSpace {
	public static void main(String[] args) {
		//堆溢出发生的原因：当所有堆内对象的大小之和超过了-Xmx指定的值，那么就会发生堆溢出
		byte[] b = new byte[1 * 1024 * 1024 * 1024];//申请1G的空间	
	}
}
