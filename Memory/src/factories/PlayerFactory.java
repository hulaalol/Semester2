package factories;

import impl.player.AbstractPlayer;
import impl.player.AbstractPlayer.PlayerType;
import impl.player.ComputerPlayer;
import impl.player.HumanPlayer;
import interfaces.GameGridInterface;


public class PlayerFactory {

	static int computerPlayerCount = 0;

	public static AbstractPlayer getPlayer(AbstractPlayer.PlayerType type, String playerName,GameGridInterface grid) {

		if (type == PlayerType.HUMAN) {
			return new HumanPlayer(playerName, grid);
		} else {
			computerPlayerCount++;
			return new ComputerPlayer(grid, computerPlayerCount);

		}

	}

}
