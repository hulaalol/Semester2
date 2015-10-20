package game;

public class MemoryGame {
	
	private GameGrid grid;
	
	public static void main(String[] args) {
		MemoryGame newGame = new MemoryGame();
		
		newGame.playGame();
	}
	
	
	
	public void playGame(){
		
		//intialisiere Spielfeld
		GameGrid gameGrid = new GameGrid();
		grid = gameGrid;
		grid.setupCards();
		
		
		//zeige Spielfeld
		MemoryCard[][] board = grid.getCards();
		
		for(int y=0; y<board.length; y++){
			
			for(int x=0; x<board.length; x++){
				
					System.out.print(board[x][y].getValue()+"\t"+"\t");
				
				
				
			}
			
			System.out.println("\n");
		}
		
		
		
	}

}
