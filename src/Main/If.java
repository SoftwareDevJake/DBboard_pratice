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
			System.out.println("�α����� �ʿ��� ����Դϴ�.");
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
			System.out.println("���θ� ��� ������ ����Դϴ�.");
			return false;
		}
	}
	
	public boolean ifArticleExists(Article article)
	{
		if(article == null)
		{
			System.out.println("�Խù��� �������� �ʽ��ϴ�.");
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
		
		if(articleId) // ���ƿ� �̹� ������ ���ƿ� ���, �ƴϸ� ���ƿ� �߰� (���ϱ�)
	}
	
}
