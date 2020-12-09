package Main.Likes;

public class Likes {
	
	private String regDate;
	private int articleId;
	private int memberNum;
	// 어떤 게시물의 어떤 멤버가 좋앙 ㅛ했는지 구별할 변수
	
	public Likes()
	{
		
	}
	
	public Likes(String regDate, int articleId, int memberNum) {
		this.regDate = regDate;
		this.articleId = articleId;
		this.memberNum = memberNum;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	
}
