package Main;

import java.util.ArrayList;

import Main.Article.Article;
import Main.Article.ArticleDao;
import Main.Comment.Comment;
import Main.Comment.CommentDao;
import Main.Likes.Likes;
import Main.Likes.LikesDao;
import Main.Member.Member;
import Main.Member.MemberDao;

public class Print {
	ArticleDao articleDao = new ArticleDao();
	CommentDao commentDao = new CommentDao();
	MemberDao memberDao = new MemberDao();
	
	ArrayList<Article> articles = new ArrayList<>();
	ArrayList<Comment> comments = new ArrayList<>();
	ArrayList<Member> members = new ArrayList<>();
	
	Article article = new Article();
	Comment comment = new Comment();
	Member member = new Member();
	
	public void articleList()
	{
		articles = articleDao.getArticles();
		members = memberDao.getMembers();
		
		for(int i = 0; i < articles.size(); i++)
		{
			System.out.println("================" + articles.get(i).getArticleId() + "번째 게시물================");
			System.out.println("articleId : " + articles.get(i).getArticleId());
			System.out.println("title : " + articles.get(i).getTitle());
			System.out.println("body : " + articles.get(i).getBody());
			System.out.println("nickname : " + members.get(articles.get(i).getMemberNum()-1).getNickname());
			System.out.println("regDate : " + articles.get(i).getRegDate());
			System.out.println("hit : " + articles.get(i).getHit());
			System.out.println("likes : " + articles.get(i).getLikes());
		}
	}
	
	public void articlePrint(int articleId)
	{
		article = articleDao.getArticleByArticleId(articleId);
		members = memberDao.getMembers();
		
		System.out.println("=======================================");
		System.out.println("articleId : " + article.getArticleId());
		System.out.println("title : " + article.getTitle());
		System.out.println("body : " + article.getBody());
		System.out.println("nickname : " + members.get(article.getMemberNum()-1).getNickname());
		System.out.println("regDate : " + article.getRegDate());
		System.out.println("hit : " + article.getHit());
		System.out.println("likes : " + article.getLikes());
		System.out.println("=======================================");
	}
	
	public void commentPrint(int articleNo)
	{
		comments = commentDao.getCommentByArticleId(articleNo);
		
		for(int i = 0; i < comments.size(); i++)
		{
			System.out.println("================ 댓글 ================");
			System.out.println("commentId : " + comments.get(i).getCommentId());
			System.out.println("comment : " + comments.get(i).getComment());
			System.out.println("nickname : " + comments.get(i).getNickname());
			System.out.println("regDate : " + comments.get(i).getRegDate());
			
		}
		System.out.println("=======================================");
		System.out.println("=======================================");
	}
	
	public void articlePrintBySearch(ArrayList<Article> articles)
	{
		members = memberDao.getMembers();
		for(int i = 0; i < articles.size(); i++)
		{
			System.out.println("================" + articles.get(i).getArticleId() + "번째 게시물================");
			System.out.println("articleId : " + articles.get(i).getArticleId());
			System.out.println("title : " + articles.get(i).getTitle());
			System.out.println("body : " + articles.get(i).getBody());
			System.out.println("nickname : " + members.get(articles.get(i).getMemberNum()-1).getNickname());
			System.out.println("regDate : " + articles.get(i).getRegDate());
			System.out.println("hit : " + articles.get(i).getHit());
			System.out.println("likes : " + articles.get(i).getLikes());
		}
	}
	
	public void articlePrintBySort(ArrayList<Article> articles)
	{
		members = memberDao.getMembers();
		for(int i = 0; i < articles.size(); i++)
		{
			System.out.println("================" + articles.get(i).getArticleId() + "번째 게시물================");
			System.out.println("articleId : " + articles.get(i).getArticleId());
			System.out.println("title : " + articles.get(i).getTitle());
			System.out.println("body : " + articles.get(i).getBody());
			System.out.println("nickname : " + members.get(articles.get(i).getMemberNum()-1).getNickname());
			System.out.println("regDate : " + articles.get(i).getRegDate());
			System.out.println("hit : " + articles.get(i).getHit());
			System.out.println("likes : " + articles.get(i).getLikes());
		}
	}
}
