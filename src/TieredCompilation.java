
/**
 * 多级编译器策略
 * 
 * @author zhangzhiwang
 * @date 2018年4月18日 下午8:31:35
 */
public class TieredCompilation {
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		Service service = new Service();
		for(int i = 0; i < 1000_0000; i++) {
			service.put();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		service = null;
		System.gc();
		Thread.sleep(2000);
	}
}

class Service {
	public void put() {
		Dao d = new Dao();
		d.add();
	}
}

class Dao {
	public void add() {
		"Dao.add".toCharArray();
	}
}
