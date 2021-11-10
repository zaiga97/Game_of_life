import java.util.Random;

public class GamePresenter{
	public final int x_dim, y_dim;
	public final GameView gw;

	private boolean[][] mat;

	public GamePresenter(int x_dim, int y_dim, GameView gw){
		this.x_dim = x_dim;
		this.y_dim = y_dim;
		this.gw = gw;

		this.mat = GenerateRandomMatrix(x_dim, y_dim);
	}

	public void draw(){
		gw.draw(mat);
	}

	boolean[][] GenerateRandomMatrix(int x_dim, int y_dim){
		Random rd = new Random();
		boolean[][] mat = new boolean[y_dim][x_dim];

		for(int j=0; j < y_dim; j++){
			for(int i=0; i < x_dim; i++){
				mat[j][i] = rd.nextBoolean();
			}
		}

		return mat;
	}
}