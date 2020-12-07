package Main.Member;

import java.util.Scanner;

public class MemberFunc {

	Scanner sc = new Scanner(System.in);
	MemberDao memberDao = new MemberDao();
	
	public void memberSignupFunc()
	{
		System.out.print("회원 아이디를 입력해 주세요 : ");
		String memberId = sc.nextLine();
		
		System.out.print("회원 비밀번호를 입력해 주세요 : ");
		String memberPass = sc.nextLine();
		
		System.out.print("회원 닉네임을 입력해 주세요 : ");
		String nickname = sc.nextLine();
		
		memberDao.memberSignup(memberId, memberPass, nickname);
	}
	
	public int memberSigninFunc(Member member, int loginCheck)
	{
		if(loginCheck >= 0)
		{
			member = memberDao.getMemberByLoginCheck(loginCheck);
			System.out.println("이미 " + member.getNickname() + "님으로 로그인 하셨습니다.");
			return loginCheck;
		}
		else
		{
			System.out.print("아이디를 입력해 주세요 : ");
			String loginId = sc.nextLine();
			
			System.out.print("비밀번호를 입력해 주세요 : ");
			String loginPass = sc.nextLine();
			
			member = memberDao.getMemberByMemberIdAndPass(loginId, loginPass);
		
		
			if(member == null)
			{
				System.out.println("로그인에 실패하셨습니다.");
				return loginCheck;
			}
			
			else
			{
				loginCheck = member.getMemberNum();
				System.out.println("환영합니다 " + member.getNickname() + "님!");
				return loginCheck;
			}
		}
	}
	
	public int memberLogout(int loginCheck)
	{
		if(loginCheck >= 0)
		{
			loginCheck = -1;
			System.out.println("로그아웃 하셨습니다.");
			return loginCheck;
		}
		else
		{
			System.out.println("로그인이 필요한 기능입니다.");
			return loginCheck;
		}
	}
	
}
