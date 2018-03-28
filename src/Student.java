import java.util.ArrayList;
import java.util.List;

/**
 * 学生类，详见课本p221 7.3.3
 * 
 * @author zhangzhiwang
 * @date 2018年3月27日 下午12:24:46
 */
public class Student {
	private int id;
	private String name;
	private List<WebPage> webHistoryList = new ArrayList<>();

	public Student() {
		super();
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WebPage> getWebHistoryList() {
		return webHistoryList;
	}

	public void setWebHistoryList(List<WebPage> webHistoryList) {
		this.webHistoryList = webHistoryList;
	}
	
	public void visit(WebPage webPage) {
		webHistoryList.add(webPage);
	}

}
