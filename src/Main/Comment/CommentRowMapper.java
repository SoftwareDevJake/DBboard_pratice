package Main.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;

import Main.RowMapper;

public class CommentRowMapper implements RowMapper<Comment>{
	
	public Comment getRow(ResultSet rs) throws SQLException
	{
		Comment comment = new Comment();
		
		int commentId = rs.getInt("id");
		String comments = rs.getString("comment");
		String nickname = rs.getString("nickname");
		String regDate = rs.getString("regDate");
		int articleNo = rs.getInt("articleNo");
		
		comment.setCommentId(commentId);
		comment.setComment(comments);
		comment.setNickname(nickname);
		comment.setRegDate(regDate);
		comment.setArticleNo(articleNo);
		
		return comment;
		
	}
	
}
