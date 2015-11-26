package interfaces;

import impl.MemoryCard;

public interface GameGridInterface {
	
	MemoryCard getCard(int a);
	
	MemoryCard[] getCards();
	
	boolean isGameOver();
	
	void setupCards();
	
}
