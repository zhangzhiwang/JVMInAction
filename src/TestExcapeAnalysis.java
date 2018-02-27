
/**
 * 逃逸分析测试
 * 
 * @author zhangzhiwang
 * @date 2018年2月27日 下午2:18:28
 */
public class TestExcapeAnalysis {
	private static Test1 test1;
	
	public void met1() {
		test1 = new Test1();//对象test1（实际上是test1所指向的对象）逃逸出了met1()方法，可能被其他线程访问
	}
	
	public Test1 met2() {
		Test1 test2 = new Test1();//test2也逃逸出了met2()方法，因为met2()方法将test2对象返回了，所以有可能被其他线程所使用
		return test2;
	}
	
	public int met3() {
		Test1 test3 = new Test1();//test3以met3()方法的局部变量的形式存在，没有被met3()方法返回，也没有任何形式地公开，所以test3没有逃逸出et3()方法，不可能被其他线程所使用，属于线程私有的变量。对于线程私有对象，该对象可能会分配在Java中而不是堆中，即栈上分配，这样随着方法的结束局部变量自动被销毁，而无需垃圾回收，提高性能
		return 0;
	}
}
