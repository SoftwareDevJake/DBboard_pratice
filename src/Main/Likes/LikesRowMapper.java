package Main.Likes;

import java.sql.ResultSet;
import java.sql.SQLException;

import Main.RowMapper;

public class LikesRowMapper implements RowMapper<Likes> {
	
	public Likes getRow(ResultSet rs) throws SQLException
	{
		Likes like = new Likes();
		
		int l = rs.getInt("like");
		int articleId = rs.getInt("articleId");
		int memberNum = rs.getInt("memberNum");
		
		like.setLike(l);
		like.setArticleId(articleId);
		like.setMemberNum(memberNum);
		
		return like;
	}
	
}
