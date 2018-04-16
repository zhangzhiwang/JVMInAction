
/**
 * 测试类加载器
 * 
 * @author zhangzhiwang
 * @date 2018年4月16日 下午1:26:35
 */
public class TestClassLoader2 {
	public static void main(String[] args) {
		//将TestClassLoader2.class放在不同的路径下使其让该类被三种加载器加载。如果要被根类加载器加载需要使用参数：-Xbootclasspath/a:[路径]
		System.out.println(TestClassLoader2.class.getClassLoader());
		System.out.println(TestClassLoader2.class.getClassLoader() == null ? "根类加载器" : "不是根类加载器");
	}
}
