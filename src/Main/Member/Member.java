package Main.Member;

public class Member {
	
	private String userId;
	private String userPass;
	private String nickname;
	private int memberNum;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public Member(String userId, String userPass, String nickname, int memberNum) {
		this.userId = userId;
		this.userPass = userPass;
		this.nickname = nickname;
		this.memberNum = memberNum;
	}
	public Member()
	{
		
	}
	
	
}
