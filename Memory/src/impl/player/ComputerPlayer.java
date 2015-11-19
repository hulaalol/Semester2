package impl.player;

import java.util.Random;
import java.util.Scanner;

import impl.GameGrid;
import impl.MemoryCard;
import interfaces.GameGridInterface;

public class ComputerPlayer extends AbstractPlayer {

	public ComputerPlayer(GameGridInterface grid, int number){
		super(("COMPUTER "+number),grid);
		this.type = PlayerType.COMPUTER;
	}

	@Override
	public MemoryCard uncoverCard() {
		
		
		GameGrid gamegrid = (GameGrid) this.grid;
		

		Random rand = new Random();

		int x = rand.nextInt(4);
		int y = rand.nextInt(4);

		return this.grid.getCard(x, y);
		
	}
	
	

}
