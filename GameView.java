public interface GameView{
	public void draw(boolean[][] mat);
}

class StdGameView implements GameView{

	@Override
	public void draw(boolean[][] mat){
		for(var y : mat){
			for(var x : y){
				System.out.print(x ? "x" : "o");
			}
			System.out.println("");
		}
	}
}