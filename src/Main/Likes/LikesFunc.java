package Main.Likes;

import Main.Article.Article;
import Main.Article.ArticleDao;
import Main.Member.Member;
import Main.Member.MemberDao;

public class LikesFunc {
	
	ArticleDao articleDao = new  ArticleDao();
	LikesDao likesDao = new LikesDao();
	MemberDao memberDao = new MemberDao();
	
	Article article = new Article();
	Likes likes = new Likes();
	Member member = new Member();
	
	public void likesInsert(int articleId, int memberId)
	{
		article = articleDao.getArticleByArticleId(articleId);
		member = memberDao.getMemberByLoginCheck(memberId);
		
		int memberNum = member.getMemberNum();
		int like = article.getLikes();
		
		if(article == null)
		{
			like = 0;
		}
		
		likesDao.insertLikes(like, articleId, memberNum);
		articleDao.updateLikes(like, articleId, memberNum);
	}
	
	public void ArticleLikes(int articleId, int memberNum)
	{
		likes = likesDao.getLikesByArticleId(articleId);
		article = articleDao.getArticleByArticleId(articleId);
		int like;
		// 다른 회원이 좋아요 할떄 1 더 추가해야함 (추가되지않고 1만 유지되는중)
		if(likes == null)
		{
			like = 0;
		}
		else
		{
			like = article.getLikes();
		}
		
		likesDao.likesArticle(like+1, articleId, memberNum);
	}
	
	public void ArticleLikesCancel(int articleId, int loginCheck)
	{
		article = articleDao.getArticleByArticleId(articleId);
		member = memberDao.getMemberByLoginCheck(loginCheck);
		
		int memberNum = member.getMemberNum();
		int like;
		
		if(article == null)
		{
			like = 0;
		}
		else
		{
			like = article.getLikes();
		}
		
		likesDao.likesCancel(articleId, loginCheck);
		articleDao.updateLikes(like, articleId, memberNum);
	}
}
