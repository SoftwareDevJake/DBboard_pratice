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
			
			System.out.print("������ �Է��� �ּ��� : ");
			String title = sc.nextLine();
			
			System.out.print("������ �Է��� �ּ��� : ");
			String body = sc.nextLine();
			
			articleDao.addArticle(title, body, member.getMemberNum(), 0, 0);
			
			article = articleDao.getArticleByMemberNum(member.getMemberNum());
			
			System.out.println("�Խù��� �߰��Ǿ����ϴ�!");
			print.articlePrint(article.getArticleId());
		}
	}
	
	public void articleDelete(int loginCheck)
	{
		if(ifs.ifLogin(loginCheck))
		{
			System.out.print("������ �Խù� ��ȣ�� �Է��� �ּ��� : ");
			int articleId = Integer.parseInt(sc.nextLine());
			
			article = articleDao.getArticleByArticleId(articleId);
			
			if(ifs.ifArticleExists(article))
			{
				if(ifs.ifRightUser(loginCheck, article))
				{
					articleDao.deleteArticle(articleId);
					System.out.println("�Խù��� �����Ǿ����ϴ�.");
				}
			}
		}
	}
	
	public void articleUpdate(int loginCheck)
	{
		if(ifs.ifLogin(loginCheck))
		{
			System.out.print("������ �Խù� ��ȣ�� �Է��� �ּ��� : ");
			int articleId = Integer.parseInt(sc.nextLine());
			
			article = articleDao.getArticleByArticleId(articleId);
			
			if(ifs.ifArticleExists(article))
			{
				if(ifs.ifRightUser(loginCheck, article))
				{
					System.out.print("������ ������ �Է��� �ּ��� : ");
					String title = sc.nextLine();
					
					System.out.print("������ ������ �Է��� �ּ��� : ");
					String body = sc.nextLine();
					
					articleDao.updateArticle(title, body, articleId);
				}
			}
		}	
	}
	
	public void articleRead(int loginCheck)
	{
		System.out.print("�󼼺����� �Խù� ��ȣ�� �Է��� �ּ��� : ");
		int articleId = Integer.parseInt(sc.nextLine());
		
		article = articleDao.readArticle(articleId); // ���� �����ִ� �Խù� ���� ��ȣ
		
		int hit = article.getHit();
		
		articleDao.hitArticle(hit+1, articleId); // ��ȸ�� 1 �߰�
		
		if(ifs.ifArticleExists(article))
		{
			print.articlePrint(articleId);
			while(true)
			{
				if(ifs.ifLogin(loginCheck))
				{
					System.out.print("�󼼺��� ����� �������ּ���(1. ��� ���, 2. ���ƿ�, 3. ����, 4. ����, 5. �������) : ");
					int choice = Integer.parseInt(sc.nextLine());
					
					if(choice == 1)
					{
						commentFunc.commentInsert(articleId); // ��� ���
					}
					else if(choice == 2)
					{
						System.out.println("���ƿ�");
					}
					else if(choice == 3)
					{
						System.out.println("����");
					}
					else if(choice == 4)
					{
						System.out.println("����");
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
