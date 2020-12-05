package Main;

import Main.Article.Article;
import Main.Article.ArticleDao;
import Main.Likes.Likes;
import Main.Likes.LikesDao;
import Main.Member.Member;
import Main.Member.MemberDao;

public class If {
	
	ArticleDao articleDao = new ArticleDao();
	LikesDao likesDao = new LikesDao();
	MemberDao memberDao = new MemberDao();
	
	Article article = new Article();
	Likes likes = new Likes();
	Member member = new Member();
	
	public boolean ifLogin(int loginCheck)
	{
		if(loginCheck == -1)
		{
			System.out.println("로그인이 필요한 기능입니다.");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean ifRightUser(int loginCheck, Article article)
	{
		if(loginCheck == article.getMemberNum())
		{
			return true;
		}
		else
		{
			System.out.println("본인만 사용 가능한 기능입니다.");
			return false;
		}
	}
	
	public boolean ifArticleExists(Article article)
	{
		if(article == null)
		{
			System.out.println("게시물이 존재하지 않습니다.");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean ifLiked(int articleId, int memberNum)
	{
		article = articleDao.getArticleByArticleId(articleId);
		likes = likesDao.getLikesByArticleIdAndMemberNum(articleId, memberNum);
		member = memberDao.getMemberByLoginCheck(memberNum);
		
		if(articleId) // 좋아요 이미 했으면 좋아요 취소, 아니면 좋아요 추가 (비교하기)
	}
	
}
