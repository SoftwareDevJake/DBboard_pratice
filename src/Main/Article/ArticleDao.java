package Main.Article;

import java.util.ArrayList;

import Main.DBUtil;

public class ArticleDao {
	
	DBUtil db = new DBUtil();
	
	public ArrayList<Article> getArticles()
	{
		String sql = "select * from article";
		
		return db.getRows(sql, new ArticleRowMapper()); 
	}
	
	public Article getArticleByArticleId(int articleId)
	{
		String sql = "select * from article where id = ?";
		
		return db.getRow(sql, new ArticleRowMapper(), articleId);
	}
	
	public Article getArticleByMemberNum(int memberNum)
	{
		String sql = "select * from article where memberNum = ?";
		
		return db.getRow(sql, new ArticleRowMapper(), memberNum);
	}
	
	public int addArticle(String title, String body, int memberNum, int hit, int likes)
	{
		String sql = "insert into article set title = ?, body = ?, memberNum = ?,"
				+ "regDate = NOW(), hit = ?, likes = ?";
		
		return db.updateQuery(sql, title, body, memberNum, hit, likes);
	}
	
	public int deleteArticle(int articleId)
	{
		String sql = "delete from article where id = ?";
		
		return db.updateQuery(sql, articleId);
	}
	
	public int updateArticle(String title, String body, int articleId)
	{
		String sql = "update article set title = ?, body = ? where id = ?";
		
		return db.updateQuery(sql, title, body, articleId);
	}
	
	public Article readArticle(int articleId)
	{
		String sql = "select * from article where id = ?";
		
		return db.getRow(sql, new ArticleRowMapper(), articleId);
	}
	
	public int hitArticle(int hit, int articleId)
	{
		String sql = "UPDATE article SET hit = ? WHERE id = ?";
		
		return db.updateQuery(sql, hit, articleId);
	}
	
	public int updateLikes(int likes, int articleId, int memberNum)
	{
		String sql = "update article set like = ? where id = ? and memberNum = ?";
		
		return db.updateQuery(sql, likes, articleId, memberNum);
	}
}
