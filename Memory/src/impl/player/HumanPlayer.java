package impl.player;

import java.util.Scanner;

import impl.GameGrid;
import impl.MemoryCard;
import interfaces.GameGridInterface;

public class HumanPlayer extends AbstractPlayer {

	public HumanPlayer(String name, GameGridInterface grid) {
		super(name, grid);
		this.type = PlayerType.HUMAN;
	}

	@Override
	public MemoryCard uncoverCard() {
		
		GameGrid gamegrid = (GameGrid) this.grid;
		
		System.out.println("Enter coordinate number");
		Scanner input = new Scanner(System.in);
		
		String coords = input.nextLine();
		char xchar = coords.charAt(1);
		char ychar = coords.charAt(0);

		int x = Character.getNumericValue(xchar)-1;
		int y = Character.getNumericValue(ychar)-1;
		
		return this.grid.getCard(x, y);

	}
}
