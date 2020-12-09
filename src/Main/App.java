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
		int loginCheck = -1; // 로그인 확인 및 member 고유넘버
		
		while(true) // while loop start
		{
			command(loginCheck);
			
			String cmd = sc.nextLine();
//======================================================================================= member func
			if(cmd.equals("member sign up"))
			{
				memberFunc.memberSignupFunc(); // 회원가입
			}
			else if(cmd.equals("member sign in"))
			{
				loginCheck = memberFunc.memberSigninFunc(member, loginCheck); // 로그인
			}
			else if(cmd.equals("member log out"))
			{
				loginCheck = memberFunc.memberLogout(loginCheck); // 로그아웃
			}
//======================================================================================= member func

//======================================================================================= article func
			else if(cmd.equals("article list"))
			{
				print.articleList(); // 게시물 출력
			}
			else if(cmd.equals("article add"))
			{
				articleFunc.articleAdd(loginCheck); // 게시물 추가
			}
			else if(cmd.equals("article delete"))
			{
				articleFunc.articleDelete(loginCheck); // 게시물 삭제
			}
			else if(cmd.equals("article update"))
			{
				articleFunc.articleUpdate(loginCheck); // 게시물 수정
			}
			else if(cmd.equals("article read"))
			{
				articleFunc.articleRead(loginCheck); // 게시물 상세보기
			}
			else if(cmd.equals("article search"))
			{
				articleFunc.articleSearch(); // 게시물 검색
			}
			else if(cmd.equals("article sort"))
			{
				articleFunc.articleSort(); // 게시물 정렬
			}
			else if(cmd.equals("article page"))
			{
				
			}
//======================================================================================= article func
			
			else if(cmd.equals("exit"))
			{
				System.out.println("종료 되었습니다."); // 나가기
				break;
			}
		}
		
	}
	
	public void command(int loginCheck)
	{
		if(loginCheck >= 0)
		{
			member = memberDao.getMemberByLoginCheck(loginCheck);
			System.out.print("명령어를 입력해 주세요 [" + member.getUserId() + "(" + member.getNickname() + ")] : ");
		}
		else
		{
			System.out.print("명령어를 입력해 주세요 : ");
		}
	}

}
