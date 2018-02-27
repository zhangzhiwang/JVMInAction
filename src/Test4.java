
/**
 * 用jclasslib查看局部变量表的曹位复用情况
 * 
 * @author zhangzhiwang
 * @date 2018年2月26日 下午4:54:45
 */
public class Test4 {
	public void met1() {
		int i1 = 1;
		int i2 = 1;
	}

	public void met2() {
		{
			int i1 = 1;
		}
		int i2 = 1;
	}
}
