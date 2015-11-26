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
	
		Random rand = new Random();

		int x = rand.nextInt(16);

		return this.grid.getCard(x);
		
	}
	
	

}
