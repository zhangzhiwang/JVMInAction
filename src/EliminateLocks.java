
/**
 * 锁消除
 * 
 * @author zhangzhiwang
 * @date 2018年4月8日 下午1:10:28
 */
public class EliminateLocks {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		EliminateLocks e = new EliminateLocks();
		for(int i = 0; i < 100_0000; i++) {
//			e.met1();
			met3("hello", " world");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public void met1() {
		int num = 0;
		num = met2(num);//想通过met2()来改变num的值，但是num非线程共享资源
	}

	public synchronized int met2(int i) {//met2()的锁是没有实际意义的
		i++;
		return i;
	}
	
	public static String met3(String s1, String s2) {
		StringBuffer s = new StringBuffer();
		s.append(s1);
		s.append(s2);
		return s.toString();
	} 
}
