package Main.Article;

public class Article {
	
	private int articleId;
	private String title;
	private String body;
	private int memberNum;
	private String regDate;
	private int hit;
	private int likes;
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public Article(int articleId, String title, String body, int memberNum, String regDate, int hit, int likes) {
		this.articleId = articleId;
		this.title = title;
		this.body = body;
		this.memberNum = memberNum;
		this.regDate = regDate;
		this.hit = hit;
		this.likes = likes;
	}
	
	public Article()
	{
		
	}
	
}
