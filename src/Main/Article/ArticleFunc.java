package Main.Article;

import java.util.ArrayList;
import java.util.Scanner;

import Main.If;
import Main.Print;
import Main.Comment.CommentFunc;
import Main.Member.Member;
import Main.Member.MemberDao;

public class ArticleFunc {
	
	ArticleDao articleDao = new ArticleDao();
	MemberDao memberDao = new MemberDao();
	
	ArrayList<Article> articles = new ArrayList<>();
	ArrayList<Member> members = new ArrayList<>();
	
	Member member = new Member();
	Article article = new Article();
	If ifs = new If();
	Print print = new Print();
	
	CommentFunc commentFunc = new CommentFunc();
	
	Scanner sc = new Scanner(System.in);
	
	public void articleAdd(int loginCheck)
	{
		if(ifs.ifLogin(loginCheck))
		{
			member = memberDao.getMemberByLoginCheck(loginCheck);
			
			System.out.print("제목을 입력해 주세요 : ");
			String title = sc.nextLine();
			
			System.out.print("내용을 입력해 주세요 : ");
			String body = sc.nextLine();
			
			articleDao.addArticle(title, body, member.getMemberNum(), 0, 0);
			
			article = articleDao.getArticleByMemberNum(member.getMemberNum());
			
			System.out.println("게시물이 추가되었습니다!");
			print.articlePrint(article.getArticleId());
		}
	}
	
	public void articleDelete(int loginCheck)
	{
		if(ifs.ifLogin(loginCheck))
		{
			System.out.print("삭제할 게시물 번호를 입력해 주세요 : ");
			int articleId = Integer.parseInt(sc.nextLine());
			
			article = articleDao.getArticleByArticleId(articleId);
			
			if(ifs.ifArticleExists(article))
			{
				if(ifs.ifRightUser(loginCheck, article))
				{
					articleDao.deleteArticle(articleId);
					System.out.println("게시물이 삭제되었습니다.");
				}
			}
		}
	}
	
	public void articleUpdate(int loginCheck)
	{
		if(ifs.ifLogin(loginCheck))
		{
			System.out.print("수정할 게시물 번호를 입력해 주세요 : ");
			int articleId = Integer.parseInt(sc.nextLine());
			
			article = articleDao.getArticleByArticleId(articleId);
			
			if(ifs.ifArticleExists(article))
			{
				if(ifs.ifRightUser(loginCheck, article))
				{
					System.out.print("수정할 제목을 입력해 주세요 : ");
					String title = sc.nextLine();
					
					System.out.print("수정할 내용을 입력해 주세요 : ");
					String body = sc.nextLine();
					
					articleDao.updateArticle(title, body, articleId);
				}
			}
		}	
	}
	
	public void articleRead(int loginCheck)
	{
		System.out.print("상세보기할 게시물 번호를 입력해 주세요 : ");
		int articleId = Integer.parseInt(sc.nextLine());
		
		article = articleDao.readArticle(articleId); // 현재 보고있는 게시물 고유 번호
		
		int hit = article.getHit();
		
		articleDao.hitArticle(hit+1, articleId); // 조회수 1 추가
		
		if(ifs.ifArticleExists(article))
		{
			print.articlePrint(articleId);
			while(true)
			{
				if(ifs.ifLogin(loginCheck))
				{
					System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
					int choice = Integer.parseInt(sc.nextLine());
					
					if(choice == 1)
					{
						commentFunc.commentInsert(articleId); // 댓글 등록
					}
					else if(choice == 2)
					{
						System.out.println("좋아요");
					}
					else if(choice == 3)
					{
						System.out.println("수정");
					}
					else if(choice == 4)
					{
						System.out.println("삭제");
					}
					else if(choice == 5)
					{
						break;
					}
				}
				else
				{
					break;
				}
			}
		}
		
	}
}
