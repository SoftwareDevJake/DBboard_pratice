package Main.Likes;

public class Likes {
	
	private int like;
	private int articleId;
	private int memberNum;
	
	public Likes()
	{
		
	}
	
	public Likes(int like, int articleId, int memberNum) {
		this.like = like;
		this.articleId = articleId;
		this.memberNum = memberNum;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
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
