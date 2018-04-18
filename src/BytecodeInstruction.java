
/**
 * 字节码指令
 * 
 * @author zhangzhiwang
 * @date 2018年4月18日 上午11:13:04
 */
public class BytecodeInstruction extends BytecodeInstructionFather {
	public static void main(String[] args) {
		BytecodeInstruction b = new BytecodeInstruction();
		BytecodeInstruction b1 = new BytecodeInstruction();
		b.met1();
		b.met2();
		b.met3();

		int i = 0;
		switch (i) {
		case 1:
			System.out.println();
			break;
		case 2:
			System.out.println();
			break;
		case 3:
			System.out.println();
			break;
		default:
			System.out.println();
		}

		switch (i) {
		case 1:
			System.out.println();
			break;
		case 300:
			System.out.println();
			break;
		case 5000:
			System.out.println();
			break;
		default:
			System.out.println();
		}

		if(i == 1) {
			System.out.println();
		}
		if(b != b1) {
			System.out.println();
		}
		
		Thread t = new Thread();
		t.run();
		((Runnable)t).run();
		
	}

	private void met1() {
	}

	public int met2() {
		return 0;
	}
	
}

class BytecodeInstructionFather {
	public void met3() {
	}
}
