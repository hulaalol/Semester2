package impl.player;

import interfaces.GameGridInterface;
import interfaces.IPlayer;

public abstract class AbstractPlayer implements IPlayer {

	protected String playerName;
	
	protected GameGridInterface grid;

	
	AbstractPlayer(String name, GameGridInterface grid){
		this.playerName = name;
		this.grid = grid;
	}
	

	@Override
	public String getPlayerName() {
		return this.playerName;
	}
	
	
}
