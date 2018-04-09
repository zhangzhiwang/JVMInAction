
/**
 * Class文件结构——魔数
 *
 * @author zhangzhiwang
 * @date 2018年4月9日 下午12:43:02
 */
public class MagicNumber {
	public static final int TYPE = 1;
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) throws IllegalStateException {
		try {
			this.id = id;
		} catch (IllegalStateException e) {
			System.out.println(e.toString());
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
