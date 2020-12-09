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
		
		likesDao.insertLikes(articleId, memberNum);
		articleDao.updateLikesInArticle(articleId, (like+1));
	}
	
	public void ArticleLikesCancel(int articleId, int loginCheck)
	{
		article = articleDao.getArticleByArticleId(articleId);
		member = memberDao.getMemberByLoginCheck(loginCheck);
		
		int like = article.getLikes();
		
		likesDao.likesCancel(articleId, loginCheck);
		articleDao.updateLikesInArticle(articleId, (like-1));
		article = articleDao.getArticleByArticleId(articleId);
	}
}
