package Main.Comment;

import java.util.ArrayList;

import Main.DBUtil;

public class CommentDao {
	DBUtil db = new DBUtil();
	
	public int insertComment(String comments, String nickname, int articleNo)
	{
		String sql = "insert into comments set comment = ?, nickname = ?, regDate = NOW(), articleNo = ?";
		
		return db.updateQuery(sql, comments, nickname, articleNo);
	}
	
	public ArrayList<Comment> getCommentByArticleId(int articleNo)
	{
		String sql = "select * from comments where articleNo = ?";
		
		return db.getRows(sql, new CommentRowMapper(), articleNo);
	}
	
}
