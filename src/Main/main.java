package Main;

public class main {
	public static void main(String[] args)
	{
		App app = new App();
		
		app.start();
		// 좋아요 부분에 likes클래스에서 좋아요를 가져올게 아니라 article 클래스에서 좋아를 가져와야함
		//(애초에 likes 클래스에는 좋아요값이 필요가 없음
		// 좋아요 했는지 안했는지 확인할떈 articleId 랑 memberNum 둘다 필요
		// 그외에 좋아요 개수만 가져오려면 article에서 가져와야함
		// article에서 가져온 좋아요를 추가 또는 취소 해야함**
		// article 과 likes 를 inner join 으로 count(articleId) 해서 가져오면 그게 likes갯수임
	}
	
	
}
