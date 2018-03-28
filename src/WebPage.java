
/**
 * 网页类，详见课本p221 7.3.3
 * 
 * @author zhangzhiwang
 * @date 2018年3月27日 下午12:26:33
 */
public class WebPage {
	private String url;
	private String content;

	public WebPage(String url, String content) {
		super();
		this.url = url;
		this.content = content;
	}

	public WebPage() {
		super();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
