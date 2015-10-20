package game;

import game.MemoryCard.state;

import java.util.Scanner;

public class MemoryGame {
	
	private GameGrid grid;
	public short score;
	

	
	public static void main(String[] args) {
		
		MemoryGame game = new MemoryGame();
		game.playGame();
		
	}
	
	
	
	public void playGame(){
		
		this.score = 1;
		this.grid = new GameGrid();
		
		
		//intialisiere Spielfeld
		grid.setupCards();
		//setze alle Karten auf state.UNSOLVED
		for(MemoryCard[] cardsCheck : grid.getCards()){
			for(MemoryCard card : cardsCheck){
				card.setState(state.UNSOLVED);
			}
		}

		//zeige Spielfeld
		this.printGrid(true);
		System.out.println("To start press enter key!");
		Scanner start = new Scanner(System.in);
		start.nextLine();
		hideGrid();
		this.printGrid(false);

		while(!(this.grid.isGameOver())){
			
			System.out.println("TURN "+(score));
			System.out.println("-------------------------------------------------------------------------------------------");
			
			MemoryCard[] flipped = new MemoryCard[2];
			for(int i=0; i<2; i++){
				
				//this.printGrid(false);
				
				System.out.println("Enter coordinate number");
				Scanner input = new Scanner(System.in);
				
				String coords = input.nextLine();
				char xchar = coords.charAt(0);
				char ychar = coords.charAt(1);

				int x = Character.getNumericValue(xchar)-1;
				int y = Character.getNumericValue(ychar)-1;

				MemoryCard flippedCard = this.grid.getCard(x, y);
				
				if(flippedCard.getState()==state.SOLVED){
					System.out.println("This card is already solved! Choose another Card!");
					this.printGrid(false);
					break;
				}
				
				flipped[i]=flippedCard;
				flippedCard.setState(state.VISIBLE);
				this.printGrid(false);
				
				if(i==1){
					
					if(flipped[0].equals(flipped[1])){
						flipped[0].setState(state.SOLVED);
						flipped[1].setState(state.SOLVED);
					}else{
						flipped[0].setState(state.UNSOLVED);
						flipped[1].setState(state.UNSOLVED);
					}

				}

			}
			
			score++;
			
			if(this.grid.isGameOver()){
				System.out.println("Congratulations! You solved the Memory in "+(score
						)+" tries!");
			}

			

			
			
		}

	}
	
	
	private void printGrid(boolean showValues){
		
		MemoryCard[][] gameGrid = grid.getCards();
		
		if(showValues){
			

			for(int y=0; y<gameGrid.length; y++){
				
				for(int x=0; x<gameGrid.length; x++){
					
						System.out.print(gameGrid[x][y].getValue()+"\t"+"\t");
				}
				
				System.out.println("\n");
			}
			
		}else{
			
			for(int y=0; y<gameGrid.length; y++){
				
				for(int x=0; x<gameGrid.length; x++){
					
					if(gameGrid[x][y].getState()==state.SOLVED){
						System.out.print(gameGrid[x][y].toString());
					}else if(gameGrid[x][y].getState()==state.VISIBLE){
						System.out.print("*"+gameGrid[x][y].toString()+"*");
					}else{
						System.out.print(gameGrid[x][y].toString()+(x+1)+(y+1));	
					}
					System.out.print("\t\t\t");
				}
				
				System.out.println("\n");
				
			}
			
		}
		
	}
	
	
	private void hideGrid(){
		
		for(int i=0; i<30; i++){
			System.out.println("\n");
		}
		
		
	}
	
	
	
	

}
