package interfaces;

import impl.MemoryCard;

public interface GameGridInterface {
	
	MemoryCard getCard(int a,int b);
	
	MemoryCard[][] getCards();
	
	boolean isGameOver();
	
	void setupCards();
	
}
