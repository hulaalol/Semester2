package impl.player;

import interfaces.GameGridInterface;
import interfaces.IPlayer;

public abstract class AbstractPlayer implements IPlayer {
	
	public enum PlayerType{
		COMPUTER,
		HUMAN;
	}

	public int playerScore;
	
	protected String playerName;
	
	protected GameGridInterface grid;

	public PlayerType type;
	
	AbstractPlayer(String name, GameGridInterface grid){
		this.playerName = name;
		this.grid = grid;
		this.playerScore = 0;
	}
	

	@Override
	public String getPlayerName() {
		return this.playerName;
	}
	
	
}
