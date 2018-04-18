import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import net.sf.cglib.transform.ClassVisitorTee;

/**
 * 
 * 
 * @author zhangzhiwang
 * @date 2018年4月18日 下午1:05:59
 */
public class TimeStatClassAdapter extends ClassVisitor {
	private String methodName;
	private String classNameWithPath;
	private String methodName1;
	private String methodSign1;
	private String methodName2;
	private String methodSign2;

	public TimeStatClassAdapter(ClassVisitor cv, String methodName, String classNameWithPath, String methodName1, String methodSign1, String methodName2, String methodSign2) {
		super(Opcodes.ASM5, cv);
		this.methodName = methodName;
		this.classNameWithPath = classNameWithPath;
		this.methodName1 = methodName1;
		this.methodSign1 = methodSign1;
		this.methodName2 = methodName2;
		this.methodSign2 = methodSign2;
	}

	public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
		MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
		MethodVisitor wrappedMv = mv;
		if (mv != null) {
			if (name.equals(methodName)) {
				wrappedMv = new TimeStatMethodAdapter(mv, classNameWithPath, methodName1, methodSign1, methodName2, methodSign2);
			}
		}
		return wrappedMv;
	}
}
