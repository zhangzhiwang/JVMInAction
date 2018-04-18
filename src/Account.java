
/**
 * 账户类
 * 
 * @author zhangzhiwang
 * @date 2018年4月18日 下午12:56:09
 */
public class Account {
	public void operation() {
		System.out.println("Account.operation()...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
