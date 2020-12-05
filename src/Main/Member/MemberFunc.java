package Main.Member;

import java.util.Scanner;

public class MemberFunc {

	Scanner sc = new Scanner(System.in);
	MemberDao memberDao = new MemberDao();
	
	public void memberSignupFunc()
	{
		System.out.print("ȸ�� ���̵� �Է��� �ּ��� : ");
		String memberId = sc.nextLine();
		
		System.out.print("ȸ�� ��й�ȣ�� �Է��� �ּ��� : ");
		String memberPass = sc.nextLine();
		
		System.out.print("ȸ�� �г����� �Է��� �ּ��� : ");
		String nickname = sc.nextLine();
		
		memberDao.memberSignup(memberId, memberPass, nickname);
	}
	
	public int memberSigninFunc(Member member, int loginCheck)
	{
		if(loginCheck >= 0)
		{
			member = memberDao.getMemberByLoginCheck(loginCheck);
			System.out.println("�̹� " + member.getNickname() + "������ �α��� �ϼ̽��ϴ�.");
			return loginCheck;
		}
		else
		{
			System.out.print("���̵� �Է��� �ּ��� : ");
			String loginId = sc.nextLine();
			
			System.out.print("��й�ȣ�� �Է��� �ּ��� : ");
			String loginPass = sc.nextLine();
			
			member = memberDao.getMemberByMemberIdAndPass(loginId, loginPass);
		
		
			if(member == null)
			{
				System.out.println("�α��ο� �����ϼ̽��ϴ�.");
				return loginCheck;
			}
			
			else
			{
				loginCheck = member.getMemberNum();
				System.out.println("ȯ���մϴ� " + member.getNickname() + "��!");
				return loginCheck;
			}
		}
	}
	
	public int memberLogout(int loginCheck)
	{
		if(loginCheck >= 0)
		{
			loginCheck = -1;
			System.out.println("�α׾ƿ� �ϼ̽��ϴ�.");
			return loginCheck;
		}
		else
		{
			System.out.println("�α����� �ʿ��� ����Դϴ�.");
			return loginCheck;
		}
	}
	
}
