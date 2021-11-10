import java.util.concurrent.TimeUnit;

public class GameApp{
	static final int XDIM = 1000;
	static final int YDIM = 1000;


	public static void main(String[] args) {

		GameView mygw = new GameOfLifeViewStdDraw(XDIM, YDIM);
		GamePresenter mygp = new GamePresenter(XDIM, YDIM, mygw);

		mygp.draw();

		for (int i = 0; i < 400; i++) {
			mygp.step();

			mygp.draw();
			try{
				TimeUnit.MILLISECONDS.sleep(20);
			}
			catch(InterruptedException e){

			}
			
		}

	}
}