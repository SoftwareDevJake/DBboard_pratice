package Main.Likes;

import java.sql.ResultSet;
import java.sql.SQLException;

import Main.RowMapper;

public class LikesRowMapper implements RowMapper<Likes> {
	
	public Likes getRow(ResultSet rs) throws SQLException
	{
		Likes like = new Likes();
		
		String regDate = rs.getString("regDate");
		int articleId = rs.getInt("articleId");
		int memberNum = rs.getInt("memberNum");
		
		like.setRegDate(regDate);
		like.setArticleId(articleId);
		like.setMemberNum(memberNum);
		
		return like;
	}
	
}
