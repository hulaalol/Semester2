package gui;

import impl.GameGrid;
import impl.MemoryCard;
import interfaces.MemoryCardInterface;

public class utils {
	
	
	boolean check2VisibleCards(GameGrid grid){
		
		int visibleCards =0;
		
		for(MemoryCard card : grid.getCards()){
			if(card.getState()==MemoryCardInterface.state.VISIBLE){
				visibleCards++;
			}
			
		}
		
		if(visibleCards==2){
			return true;
		}else{
			return false;
		}
		
		
		
		
	}
	
	
	

}
