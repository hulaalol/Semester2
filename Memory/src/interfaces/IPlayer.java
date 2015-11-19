package interfaces;

import impl.MemoryCard;

public interface IPlayer {
	
	MemoryCard uncoverCard();
	
	String getPlayerName();

}
