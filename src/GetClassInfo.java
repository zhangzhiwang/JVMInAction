import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取Class的元信息
 * 
 * @author zhangzhiwang
 * @date 2018年4月14日 下午4:24:55
 */
public class GetClassInfo {
	public static void main(String[] args) throws Exception {
		//类装载的第一步就是加载类，即通过类的全名称将相应的.class文件读取到JVM中（由ClassLoader完成）并生成相应的Class对象保存在永久区
		Class clazz = Class.forName("java.lang.String");
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m : methods) {
			String modifier = Modifier.toString(m.getModifiers());
			System.out.print(modifier + " " + m.getName() + " (");
			Class[] paramTypes = m.getParameterTypes();
			if(paramTypes.length == 0) {
				System.out.print(")");
			}
			for(Class pt : paramTypes) {
				System.out.print(pt.getSimpleName() + ",");
			}
			System.out.println();
		}
	}
}
