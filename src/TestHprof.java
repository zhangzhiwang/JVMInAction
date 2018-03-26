
/**
 * 测试hprof
 * 
 * @author zhangzhiwang
 * @date 2018年3月23日 上午11:19:29
 */
public class TestHprof {
	public void met1() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	public void met2() throws InterruptedException {
		Thread.sleep(10000);
	}
	
	public void met3() {
		Thread.yield();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestHprof t = new TestHprof();
		t.met1();
		t.met2();
		t.met3();
	}
}
