import java.util.ArrayList;
import java.util.List;

/**
 * 跟踪学生访问的网页	
 * 
 * @author zhangzhiwang
 * @date 2018年3月27日 下午12:29:28
 */
public class TraceStudent {
	public static List<WebPage> webPages = new ArrayList<>();
	
	private static void createPages() {
		for(int i = 0; i < 100; i++) {//创建100个网页
			WebPage webPage = new WebPage("www." + i + ".com", "content_" + i);
			webPages.add(webPage);
		}
	}
	
	public static void main(String[] args) {
		createPages();
		
		Student s1 = new Student(3, "aaa");
		Student s2 = new Student(5, "bbb");
		Student s3 = new Student(7, "ccc");
		
		for(int i = 0; i < webPages.size(); i++) {
			if(i % s1.getId() == 0) {
				s1.visit(webPages.get(i));
			}
			if(i % s2.getId() == 0) {
				s2.visit(webPages.get(i));
			}
			if(i % s3.getId() == 0) {
				s3.visit(webPages.get(i));
			}
		}
		webPages.clear();
		System.gc();
	}
}
