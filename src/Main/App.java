package Main;

import java.util.Scanner;

import Main.Article.ArticleFunc;
import Main.Member.Member;
import Main.Member.MemberDao;
import Main.Member.MemberFunc;

public class App {

	MemberDao memberDao = new MemberDao();
	Member member = new Member();
	
	MemberFunc memberFunc = new MemberFunc();
	ArticleFunc articleFunc = new ArticleFunc();
	
	Print print = new Print();
	
	public void start() {
		
		Scanner sc = new Scanner(System.in);
		int loginCheck = -1; // �α��� Ȯ�� �� member ���� �ѹ�
		
		while(true) // while loop start
		{
			command(loginCheck);
			
			String cmd = sc.nextLine();
//======================================================================================= member func
			if(cmd.equals("member sign up"))
			{
				memberFunc.memberSignupFunc(); // ȸ������
			}
			else if(cmd.equals("member sign in"))
			{
				loginCheck = memberFunc.memberSigninFunc(member, loginCheck); // �α���
			}
			else if(cmd.equals("member log out"))
			{
				loginCheck = memberFunc.memberLogout(loginCheck); // �α׾ƿ�
			}
//======================================================================================= member func

//======================================================================================= article func
			else if(cmd.equals("article list"))
			{
				print.articleList(); // �Խù� ���
			}
			else if(cmd.equals("article add"))
			{
				articleFunc.articleAdd(loginCheck); // �Խù� �߰�
			}
			else if(cmd.equals("article delete"))
			{
				articleFunc.articleDelete(loginCheck); // �Խù� ����
			}
			else if(cmd.equals("article update"))
			{
				articleFunc.articleUpdate(loginCheck); // �Խù� ����
			}
			else if(cmd.equals("article read"))
			{
				articleFunc.articleRead(loginCheck); // �Խù� �󼼺���
			}
//======================================================================================= article func
			
			
			
			else if(cmd.equals("exit"))
			{
				System.out.println("���� �Ǿ����ϴ�."); // ������
				break;
			}
		}
		
	}
	
	public void command(int loginCheck)
	{
		if(loginCheck >= 0)
		{
			member = memberDao.getMemberByLoginCheck(loginCheck);
			System.out.print("��ɾ �Է��� �ּ��� [" + member.getUserId() + "(" + member.getNickname() + ")] : ");
		}
		else
		{
			System.out.print("��ɾ �Է��� �ּ��� : ");
		}
	}

}
