
/**
 * 测试类的加载
 * 
 * @author zhangzhiwang
 * @date 2018年4月14日 下午3:38:41
 */
public class LoadClass {
	public static void main(String[] args) {
//		new Child();//1、使用new关键字创建对象时，属于对类的主动使用，主动使用会导致该类的初始化 2、初始化某类时会先初始化该类的父类
//		System.out.println(Child.age);//此种情况是对父类的主动使用而非对子类的主动使用。当类的静态子段或方法被调用时属于对定义改子段或方法的类的主动使用
//		Child.met1();
		System.out.println(Parent.NAME);//上面的注释再补充一下：使用类的静态子段时属于对定义该静态子段的类的主动使用，final常量除外
	}
}

class Parent {
	public static final String NAME = "aaa";
	public static int age = 10;
	static {
		System.out.println("Parent inited!");
	}
	
	public static void met1() {}
}

class Child extends Parent {
	static {
		System.out.println("Child inited!");
	}
}