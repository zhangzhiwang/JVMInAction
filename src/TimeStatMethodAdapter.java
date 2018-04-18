import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * 
 * 
 * @author zhangzhiwang
 * @date 2018年4月18日 下午1:25:41
 */
public class TimeStatMethodAdapter extends MethodVisitor implements Opcodes {
	private String classNameWithPath;
	private String methodName1;
	private String methodSign1;
	private String methodName2;
	private String methodSign2;
	
	public TimeStatMethodAdapter(MethodVisitor mv, String classNameWithPath, String methodName1, String methodSign1, String methodName2, String methodSign2) {
		super(Opcodes.ASM5, mv);
		this.classNameWithPath = classNameWithPath;
		this.methodName1 = methodName1;
		this.methodSign1 = methodSign1;
		this.methodName2 = methodName2;
		this.methodSign2 = methodSign2;
	}
	
	@SuppressWarnings("deprecation")
	public void visitCode() {
		visitMethodInsn(Opcodes.INVOKESTATIC, classNameWithPath, methodName1, methodSign1);
		super.visitCode();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void visitInsn(int opcode) {
		if(opcode >= IRETURN && opcode <= RETURN) {
			visitMethodInsn(Opcodes.INVOKESTATIC, classNameWithPath, methodName2, methodSign2);
		}
		mv.visitInsn(opcode);
	}
}
