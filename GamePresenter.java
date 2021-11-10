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

	public void step(){
		boolean[][] nextGen = new boolean[y_dim][x_dim];
		int neighbors;

		for(int j=0; j < y_dim; j++){
			for(int i=0; i < x_dim; i++){
				neighbors = CountNeighbors(i, j);
				switch(neighbors){
					case 2:
						nextGen[j][i] = mat[j][i];
					break;
					case 3:
						nextGen[j][i] = true;
					break;
					default:
						nextGen[j][i] = false; 
				}
			}
		}
		mat = nextGen;
	}

	private int CountNeighbors(int x, int y){
		int numNeighbors = 0;

        // Look NW
        if ((y - 1 >= 0) && (x - 1 >= 0)) {
            numNeighbors = mat[y - 1][x- 1] ? numNeighbors + 1 : numNeighbors;
        }
        // Look W
        if ((x - 1 >= 0)) {
            numNeighbors = mat[y][x - 1] ? numNeighbors + 1 : numNeighbors;
        }
        // Look SW
        if ((y + 1 < y_dim) && (x - 1 >= 0)) {
            numNeighbors = mat[y + 1][x - 1] ? numNeighbors + 1 : numNeighbors;
        }
        // Look S
        if ((y + 1 < y_dim)) {
            numNeighbors = mat[y + 1][x] ? numNeighbors + 1 : numNeighbors;
        }
        // Look SE
        if ((y + 1 < y_dim) && (x + 1 < x_dim)) {
            numNeighbors = mat[y + 1][x + 1] ? numNeighbors + 1 : numNeighbors;
        }
        // Look E
        if ((x + 1 < x_dim)) {
            numNeighbors = mat[y][x + 1] ? numNeighbors + 1 : numNeighbors;
        }
        // Look NE
        if ((y - 1 >= 0) && (x + 1 < x_dim)) {
            numNeighbors = mat[y - 1][x + 1] ? numNeighbors + 1 : numNeighbors;
        }
        // Look N
        if ((y - 1 >= 0)) {
            numNeighbors = mat[y - 1][x] ? numNeighbors + 1 : numNeighbors;
        }

        return numNeighbors;
    }


	private boolean[][] GenerateRandomMatrix(int x_dim, int y_dim){
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