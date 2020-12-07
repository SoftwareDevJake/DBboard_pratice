package Main.Comment;

import java.util.ArrayList;
import java.util.Scanner;

import Main.Print;
import Main.Article.Article;
import Main.Article.ArticleDao;
import Main.Member.Member;
import Main.Member.MemberDao;

public class CommentFunc {
	
	ArticleDao articleDao = new ArticleDao();
	CommentDao commentDao = new CommentDao();
	MemberDao memberDao = new MemberDao();
	
	Article article = new Article();
	Member member = new Member();
	Comment comment = new Comment();
	
	ArrayList<Member> members = new ArrayList<>();
	
	Print print = new Print();
	
	Scanner sc = new Scanner(System.in);
	
	public void commentInsert(int articleNo, int loginCheck)
	{
		System.out.print("댓글 내용을 입력해 주세요 : ");
		String comments = sc.nextLine();
		
		article = articleDao.getArticleByArticleId(articleNo);
		member = memberDao.getMemberByLoginCheck(loginCheck);
//		members = memberDao.getMembers();
		
//		String nickname = members.get(article.getMemberNum()-1).getNickname();
		
		String nickname = member.getNickname();
		System.out.println("nickname = " + nickname);
		
		commentDao.insertComment(comments, nickname, articleNo);
		System.out.println("댓글 입력 완료하였습니다!");
		
		print.articlePrint(articleNo);
		print.commentPrint(articleNo);
		
	}
	
}
