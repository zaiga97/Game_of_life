public class GameApp{
	public static void main(String[] args) {

		GameView mygw = new StdGameView();
		GamePresenter mygp = new GamePresenter(10, 10, mygw);

		
		mygp.draw();
	}
}