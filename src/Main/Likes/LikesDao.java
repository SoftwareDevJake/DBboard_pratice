package Main.Likes;

import java.util.ArrayList;

import Main.DBUtil;

public class LikesDao {
	
	DBUtil db = new DBUtil();
	
	public int insertLikes(int like, int articleId, int memberNum)
	{
		String sql = "insert into likes set `like` = ?, articleId = ?, memberNum = ?";
		
		return db.updateQuery(sql, like, articleId, memberNum);
	}
	
	public Likes getLikesByArticleId(int articleId)
	{
		String sql = "select * from likes where articleId = ?";
		
		return db.getRow(sql, new LikesRowMapper(), articleId);
	}
	
	public int likesArticle(int like, int articleId, int memberNum)
	{
		String sql = "update likes set `like` = ? where articleId = ? and memberNum = ?";
		
		return db.updateQuery(sql, like, articleId, memberNum);
	}
	
	public ArrayList<Likes> getLikes(int articleId, int memberNum)
	{
		String sql = "select * from likes where articleId = ? and memberNum = ?";
		
		return db.getRows(sql, new LikesRowMapper(), articleId, memberNum);
	}
	
	public int likesCancel(int articleId, int memberNum)
	{
		String sql = "DELETE FROM likes WHERE articleId = ? AND memberNum = ?";
		
		return db.updateQuery(sql, articleId, memberNum);
	}
}
