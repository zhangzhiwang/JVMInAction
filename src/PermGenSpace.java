import java.util.HashMap;

/**
 * 永久区溢出
 * 
 * @author zhangzhiwang
 * @date 2018年3月26日 上午11:00:18
 */
public class PermGenSpace {
	public static void main(String[] args) throws ClassNotFoundException {
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
