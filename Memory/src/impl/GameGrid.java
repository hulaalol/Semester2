package impl;

import interfaces.GameGridInterface;
import interfaces.MemoryCardInterface.state;

import java.util.concurrent.ThreadLocalRandom;

public class GameGrid implements GameGridInterface {
	
	private String[] cardValues = {"Affe","Hund","Tiger","Löwe","Yak","Dachs","Pferd","Kuh"};
	private MemoryCard[]cards = new MemoryCard[16];
	
	
	private void placeCards(String value){
		
			int x1=0;
			
			int x2=0;
			
			for(int k=0; k<2; k++){
				
				int x = ThreadLocalRandom.current().nextInt(0,(cardValues.length*2));
				int y = ThreadLocalRandom.current().nextInt(0,(cardValues.length*2));
				
				if(k==0){
					x1 = x;
				}else if(k==1 && (x!=x1)){
					x2 = x;
					
					if(cards[x1]==null && cards[x2]==null){
						cards[x1]= new MemoryCard(value);
						cards[x2]= new MemoryCard(value);
						
						//set status of new placed cards to unsolved
						cards[x1].setState(state.UNSOLVED);
						cards[x2].setState(state.UNSOLVED);
					}else{
						k=-1;
					}

				}else{
					k--;
				}
				
				
			}

			
		//}

	}
	
	
	public void setupCards(){
		for(String card : cardValues){
			placeCards(card);
		}
	}
	
	public MemoryCard getCard(int x){
		return cards[x];
	}
	
	public void lockCards(){
		
		for(MemoryCard card : cards){
			card.locked = true;
		}	
	}
	
	public void unlockCards(){
		for(MemoryCard card : cards){
			card.locked = false;
		}
	}
	
	public boolean isGameOver(){
		
		for(MemoryCard cardsCheck : cards){
		
				if(cardsCheck.getState() == state.UNSOLVED){
					return false;
				}
		}
		
		return true;
	}
	
	public MemoryCard[] getCards(){
		return cards;
	}

}
