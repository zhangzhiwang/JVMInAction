import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * 使用ASM动态生成类
 * 
 * @author zhangzhiwang
 * @date 2018年4月14日 下午2:24:01
 */
public class ASM extends ClassLoader implements Opcodes {
	public static void main(String[] args) throws Exception {
		// 开始使用ASM动态创建类
		// 创建ClassWriter，COMPUTE_MAXS使ASM自动计算最大局部变量和最深操作数栈，COMPUTE_FRAMES使ASM自动计算栈映射帧
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		// 设置被创建的类的定义：被创建的类名为“ASMCreatClass”，访问标记符为public，父类为Object
		classWriter.visit(V1_7, ACC_PUBLIC, "ASMCreatClass", null, "java/lang/Object", null);
		// 生成ASMCreatClass的构造方法
		MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		methodVisitor.visitInsn(RETURN);
		methodVisitor.visitMaxs(0, 0);
		methodVisitor.visitEnd();
		// 生成main()方法
		classWriter.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// main()方法里面调用System.out.println();
		methodVisitor.visitLdcInsn("Hello World!");// println()方法的参数
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");// 对System.out.println();的描述：该方法所在的类是什么，方法名是什么，参数是什么，返回值是什么
		methodVisitor.visitInsn(RETURN);
		methodVisitor.visitMaxs(0, 0);
		methodVisitor.visitEnd();

		byte[] code = classWriter.toByteArray();

		ASM asm = new ASM();
		Class c = asm.defineClass("ASMCreatClass", code, 0, code.length);
		c.getMethods()[0].invoke(null, new Object[] { null });
	}
}
