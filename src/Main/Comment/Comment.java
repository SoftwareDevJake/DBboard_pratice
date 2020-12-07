package Main.Comment;

public class Comment {
	
	private int commentId;
	private String comment;
	private String nickname;
	private String regDate;
	private int articleNo;
	
	public Comment()
	{
		
	}
	
	public Comment(int commentId, String comment, String nickname, String regDate, int articleNo) {
		this.commentId = commentId;
		this.comment = comment;
		this.nickname = nickname;
		this.regDate = regDate;
		this.articleNo = articleNo;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	
}
