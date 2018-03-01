import java.util.HashMap;

/**
 * 写一段程序使之产生永久区溢出
 * 
 * @author zhangzhiwang
 * @date 2018年2月28日 上午11:45:34
 */
public class TestOOMPermGenSpace {
	public static void main(String[] args) {
		//永久区保存着类信息，只要让程序产生大量的类就可以占用大量的永久区空间，cglib可以动态产生类
		//运行时尽量减小永久区的大小
		int i = 0;
		try {
			for(i = 0; i < 1000000; i++) {
				HashMap<String, Object> propertyMap = new HashMap<>();
				propertyMap.put("id", Class.forName("java.lang.Integer"));
				propertyMap.put("name", Class.forName("java.lang.String"));
				propertyMap.put("address", Class.forName("java.lang.String"));

				new CglibBean(propertyMap);
			}
		} catch (Throwable e) {
			System.out.println("永久区溢出");
			System.out.println("总共动态创建类：" + i);
			e.printStackTrace();
		}
	}
}
