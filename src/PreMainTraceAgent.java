import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * 在目标类的main()方法执行前执行的类
 * 
 * @author zhangzhiwang
 * @date 2018年4月18日 下午2:19:54
 */
public class PreMainTraceAgent {
	public static void premain(String agentArgs, Instrumentation inst) {
		System.out.println("agentArgs : " + agentArgs);
		inst.addTransformer(new ClassFileTransformer() {
			
			@Override
			public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
				System.out.println("loaded class : " + className);
				return classfileBuffer;
			}
		});
	}
}
