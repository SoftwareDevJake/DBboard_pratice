package Main.Article;

import java.sql.ResultSet;
import java.sql.SQLException;

import Main.RowMapper;

public class ArticleRowMapper implements RowMapper<Article> {
	
	public Article getRow(ResultSet rs) throws SQLException
	{
		Article article = new Article();
		
		int id = rs.getInt("id");
		String title = rs.getString("title");
		String body = rs.getString("body");
		int memberNum = rs.getInt("memberNum");
		String regDate = rs.getString("regDate");
		int hit = rs.getInt("hit");
		int likes = rs.getInt("likes");
		
		article.setArticleId(id);
		article.setTitle(title);
		article.setBody(body);
		article.setMemberNum(memberNum);
		article.setRegDate(regDate);
		article.setHit(hit);
		article.setLikes(likes);
				
		return article;
	}
	
}
