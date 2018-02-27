
/**
 * 栈上分配
 * 
 * @author zhangzhiwang
 * @date 2018年2月27日 下午2:33:22
 */
public class TestOnStack {
	public static class User {
		public int id;
		public String name;
	}

	public static void met1() {
		User u = new User();
		u.id = 1;
		u.name = "aaa";
	}

	public static void main(String[] args) {
		//用命令运行：java -server -Xms10m -Xmx10m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB -XX:+EliminateAllocations TestOnStack
		//关闭逃逸分析再运行一下
		for (int i = 0; i < 1_0000_0000; i++) {
			met1();
		}
		System.out.println("ok");
	}

}
