package Main.Article;

import java.util.ArrayList;
import java.util.Scanner;

import Main.If;
import Main.Print;
import Main.Comment.CommentFunc;
import Main.Likes.Likes;
import Main.Likes.LikesDao;
import Main.Likes.LikesFunc;
import Main.Member.Member;
import Main.Member.MemberDao;

public class ArticleFunc {
	
	ArticleDao articleDao = new ArticleDao();
	MemberDao memberDao = new MemberDao();
	LikesDao likesDao = new LikesDao();
	
	ArrayList<Article> articles = new ArrayList<>();
	ArrayList<Member> members = new ArrayList<>();
	
	Member member = new Member();
	Article article = new Article();
	Likes like_c = new Likes();
	If ifs = new If();
	Print print = new Print();
	
	CommentFunc commentFunc = new CommentFunc();
	LikesFunc likesFunc = new LikesFunc();
	
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
//			likesFunc.likesInsert(article.getArticleId(), loginCheck); // 좋아요 항목 추가
			
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
		
		if(ifs.ifArticleExists(article))
		{
			int hit = article.getHit();
			
			articleDao.hitArticle(hit+1, articleId); // 조회수 1 추가
			
			if(ifs.ifArticleExists(article))
			{
				print.articlePrint(articleId);
				print.commentPrint(articleId);
				while(true)
				{
					if(ifs.ifLogin(loginCheck))
					{
						System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로 : ");
						int choice = Integer.parseInt(sc.nextLine());
						
						if(choice == 1)
						{
							commentFunc.commentInsert(articleId, loginCheck); // 댓글 등록
						}
						else if(choice == 2)
						{
							like_c = likesDao.getLikesByArticleIdAndMemberNum(articleId, loginCheck);
							
							if(ifs.ifLiked(like_c))
							{
								likesFunc.ArticleLikesCancel(articleId, loginCheck);
								System.out.println("\n좋아요를 취소했습니다.\n");
							}
							else
							{
								likesFunc.likesInsert(article.getArticleId(), loginCheck);
								System.out.println("\n좋아요 했습니다.\n");
							}
							print.articlePrint(articleId);
							print.commentPrint(articleId);
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
						else
						{
							System.out.println("다시 시도해 주세요.");
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
	
	public void articleSearch()
	{
		System.out.print("검색 항목을 선택해 주세요 (1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자) : ");
		int choice = Integer.parseInt(sc.nextLine());
		
		if(choice == 1)
		{
			System.out.print("제목 검색 키워드를 입력해 주세요 : ");
			String keyword = sc.nextLine();
			
			articles = articleDao.getArticleSearchByTitle(keyword);
			
			print.articlePrintBySearch(articles);
		}
		
		else if(choice == 2)
		{
			System.out.println("내용 검색 키워드를 입력해 주세요 : ");
			String keyword = sc.nextLine();
			
			articles = articleDao.getArticleSearchByBody(keyword);
			
			print.articlePrintBySearch(articles);
		}
		
		else if(choice == 3)
		{
			System.out.println("제목 또는 내용 검색 키워드를 입력해 주세요 : ");
			String keyword = sc.nextLine();
			
			articles = articleDao.getArticleSearchByTitleAndBody(keyword);
			
			print.articlePrintBySearch(articles);
		}
		
		else if(choice == 4)
		{
			System.out.println("닉네임 검색 키워드를 입력해 주세요 : ");
			String keyword = sc.nextLine();
			
			articles = articleDao.getArticleSearchByNickname(keyword);
			
			print.articlePrintBySearch(articles);
		}
		
		else
		{
			System.out.println("잘못 입력 하셨습니다.");
		}
	}
	
	public void articleSort()
	{
		System.out.println("정렬 대상을 선택해주세요. (like : 좋아요, hit : 조회수) :");
		String sortType = sc.nextLine();
		
		if(sortType.equals("like"))
		{
			System.out.println("정렬 방법을 선택해주세요. (asc : 오름차순, desc : 내림차순) :");
			String sortWay = sc.nextLine();
			
			if(sortWay.equals("asc"))
			{
				articles = articleDao.getArticleSortOrderByHitASC();
				
				print.articlePrintBySort(articles);
			}
			else if(sortWay.equals("desc"))
			{
				articles = articleDao.getArticleSortOrderByHitDESC();
				
				print.articlePrintBySort(articles);
			}
			else
			{
				System.out.println("잘못 입력 하셨습니다.");
			}
		}
		
		else if(sortType.equals("hit"))
		{
			System.out.println("정렬 방법을 선택해주세요. (asc : 오름차순, desc : 내림차순) :");
			String sortWay = sc.nextLine();
			
			if(sortWay.equals("asc"))
			{
				articles = articleDao.getArticleSortOrderByHitASC();
				
				print.articlePrintBySort(articles);
			}
			else if(sortWay.equals("desc"))
			{
				articles = articleDao.getArticleSortOrderByHitDESC();
				
				print.articlePrintBySort(articles);
			}
			else
			{
				System.out.println("잘못 입력 하셨습니다.");
			}
		}
	}
}
