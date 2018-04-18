import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

/**
 * 记录某一方法的执行时间
 * 
 * @author zhangzhiwang
 * @date 2018年4月18日 下午1:01:58
 */
public class TimeStatWeaveGenerator {
	public static void main(String[] args) throws Exception {//args数组第一个元素为被修改的class的路径，第二个元素为类的全限定名，如："/Applications/workspace_cust2.0/JVMInAction/build/classes/" Account
		String className = args[1];
		ClassReader cr = new ClassReader(className);
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		TimeStatClassAdapter classAdapter = new TimeStatClassAdapter(cw, "operation", "TimeStat", "start", "()V", "end", "()V");
		cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
		byte[] data = cw.toByteArray();
		File file = new File(args[0] + className.replaceAll("\\.", "/") + ".class");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(data);
		fos.close();
	}
}
