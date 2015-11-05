package impl.player;

import java.util.Scanner;

import impl.GameGrid;
import impl.MemoryCard;
import interfaces.GameGridInterface;

public class ComputerPlayer extends AbstractPlayer {

	public ComputerPlayer(GameGridInterface grid, int number){
		super(("COMPUTER "+number),grid);
	}

	@Override
	public MemoryCard uncoverCard() {
		
		
		GameGrid gamegrid = (GameGrid) this.grid;
		
		System.out.println("Computer chooses card");

		int x = (int) Math.round((Math.random()*4));
		int y = (int) Math.round((Math.random()*4));

		return this.grid.getCard(x, y);
		
	}
	
	

}
