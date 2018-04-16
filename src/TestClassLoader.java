
/**
 * 测试类加载器
 * 
 * @author zhangzhiwang
 * @date 2018年4月16日 下午1:11:22
 */
public class TestClassLoader {
	public static void main(String[] args) {
		//根类加载器加载系统的核心类，rt.jar就是系统的核心类
		//扩展类加载器加载%JAVA_HOMW%/
		ClassLoader classLoader = TestClassLoader.class.getClassLoader();
		while(classLoader != null) {
			System.out.println(classLoader);
			classLoader = classLoader.getParent();
			if(classLoader == null) {
				System.out.println("根类加载器");
			}
		}
	}
}
