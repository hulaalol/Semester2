package impl;


import interfaces.IPlayer;
import factories.PlayerFactory;
import impl.player.AbstractPlayer;
import impl.player.AbstractPlayer.PlayerType;
import impl.player.ComputerPlayer;
import impl.player.HumanPlayer;
import interfaces.MemoryCardInterface.state;
import interfaces.MemoryGameInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class MemoryGame implements MemoryGameInterface {
	
	private GameGrid grid;
	public short score;
	
	public ArrayList<AbstractPlayer> players = new ArrayList<AbstractPlayer>();
	

	public static void main(String[] args) {
		
		MemoryGame game = new MemoryGame();
		game.playGame();
		
	}
	
	
	
	public void playGame(){
		
		this.score = 1;
		this.grid = new GameGrid();
		
		Scanner start = new Scanner(System.in);
		
		System.out.println("How many Human players want to participate?");
		int humanplayers = start.nextInt();
		
		for(int i=0; i<humanplayers;i++){
			
			System.out.println("Enter Player "+(i+1)+" Name:");
			
			players.add(PlayerFactory.getPlayer(PlayerType.HUMAN,start.next(),this.grid));
			
			
		}
		
		System.out.println("How many Computer players do you want to play against??");
		int computerplayers = start.nextInt();
		
		for(int i=0; i<computerplayers;i++){
			
			players.add(PlayerFactory.getPlayer(PlayerType.COMPUTER,"computer",this.grid));
			System.out.println("COMPUTER "+(i+1)+" added!");
			
		}
		
		
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
		
		start.nextLine();
		hideGrid();

		while(!(this.grid.isGameOver())){
			
			System.out.println("TURN "+(score));
			System.out.println("-------------------------------------------------------------------------------------------");
			
			
			
			for(AbstractPlayer player : players){
				
				if(this.grid.isGameOver()){
					break;
				}
				
				score++;
				
				System.out.println("It is PLAYER:"+player.getPlayerName()+"'s turn now!");
				this.printGrid(false);
				
				MemoryCard[] flipped = new MemoryCard[2];
				
				for(int i=0; i<2; i++){
					
					MemoryCard flippedCard = player.uncoverCard();
					flipped[i]=flippedCard;
					
					
					
					if(flippedCard.getState()==state.SOLVED || (flipped[1]!=null && flipped[0]==flipped[1])){
						
						if(player.type==PlayerType.HUMAN){
							System.out.println("This card is already solved! Choose another Card!");
							this.printGrid(false);
						}
						
						i--;
						continue;
					}
					
					
					
					if(player.type == PlayerType.COMPUTER){
					System.out.println("Computer chooses card");
					}
					flippedCard.setState(state.VISIBLE);
					this.printGrid(false);
					
					if(i==1){
						
						if(flipped[0].equals(flipped[1])){
							flipped[0].setState(state.SOLVED);
							flipped[1].setState(state.SOLVED);
							player.playerScore++;
						}else{
							flipped[0].setState(state.UNSOLVED);
							flipped[1].setState(state.UNSOLVED);
						}
						
						
						
						
						
						if(this.grid.isGameOver()){
							
							int winnerScore = 0;
							winnerScore = players.get(0).playerScore;
							AbstractPlayer realWinner = players.get(0);
							
							for(AbstractPlayer winner : players){
							
								if(winner.playerScore > winnerScore){
									realWinner = winner;
								}
								
							}
							
							System.out.println("The Winner is "+realWinner.getPlayerName()+" with "+realWinner.playerScore+" solved pairs!");
							
						}else if(!(this.grid.isGameOver())){
							Scanner nextPlayer = new Scanner(System.in);
							System.out.println("To continue with next Player press Enter");
							nextPlayer.nextLine();
						}
						
						
						
					}
					
					
				
					
					
					
					
				}
				
				
				
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
