package Main.Member;

import java.util.ArrayList;

import Main.DBUtil;

public class MemberDao {
	DBUtil db = new DBUtil();
	
	public int memberSignup(String memberId, String memberPass, String nickname)
	{
		String sql = "insert into members set id = ?, pass = ?, nickname = ?";
		
		return db.updateQuery(sql, memberId, memberPass, nickname);
	}
	
	public ArrayList<Member> getMembers()
	{
		String sql = "select * from members";
		
		return db.getRows(sql, new MemberRowMapper());
	}
	
	public Member getMemberByMemberIdAndPass(String loginId, String loginPass)
	{
		String sql = "select * from members where id = ? and pass = ?";
		
		return db.getRow(sql, new MemberRowMapper(), loginId, loginPass);
	}
	
	public Member getMemberByLoginCheck(int loginCheck)
	{
		String sql = "select * from members where num = ?";
		
		return db.getRow(sql, new MemberRowMapper(), loginCheck);
	}
	
}
