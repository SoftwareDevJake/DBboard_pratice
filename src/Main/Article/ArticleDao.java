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
		String sql = "update article set likes = ? where id = ? and memberNum = ?";
		
		return db.updateQuery(sql, likes, articleId, memberNum);
	}
	
	public ArrayList<Article> getArticleSearchByTitle(String keyword)
	{
		String sql = "select * from article where title like concat_ws(?,'%','%')";
		
		return db.getRows(sql, new ArticleRowMapper(), keyword);
	}
	
	public ArrayList<Article> getArticleSearchByBody(String keyword)
	{
		String sql = "select * from article where body like concat_ws(?,'%','%')";
		
		return db.getRows(sql, new ArticleRowMapper(), keyword);
	}
	
	public ArrayList<Article> getArticleSearchByTitleAndBody(String keyword)
	{
		String sql = "select * from article where title like concat_ws(?,'%','%') or body like concat_ws(?,'%','%')";
		
		return db.getRows(sql, new ArticleRowMapper(), keyword, keyword);
	};
	
	public ArrayList<Article> getArticleSearchByNickname(String keyword)
	{
		String sql = "SELECT * FROM article a INNER JOIN members m ON a.memberNum = m.num WHERE nickname LIKE CONCAT_WS(?,'%','%')";
		
		return db.getRows(sql, new ArticleRowMapper(), keyword);
	}
	
	public ArrayList<Article> getArticleSortOrderByHitASC()
	{
		String sql = "SELECT * FROM article ORDER BY hit";
		
		return db.getRows(sql, new ArticleRowMapper());
	}
	
	public ArrayList<Article> getArticleSortOrderByHitDESC()
	{
		String sql = "SELECT * FROM article ORDER BY hit desc";
		
		return db.getRows(sql, new ArticleRowMapper());
	}
}
