package Main.Likes;

import Main.DBUtil;

public class LikesDao {
	
	DBUtil db = new DBUtil();
	
	public int insertLikes(int like, int articleId, int memberNum)
	{
		String sql = "insert into likes set like = ? where articleId = ? and memberNum = ?";
		
		return db.updateQuery(sql, like, articleId, memberNum);
	}
	
	public Likes getLikesByArticleIdAndMemberNum(int articleId, int memberNum)
	{
		String sql = "select * from likes where articleId = ? and memberNum = ?";
		
		return db.getRow(sql, new LikesRowMapper(), articleId, memberNum);
	}
	
}
