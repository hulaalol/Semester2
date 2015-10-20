package game;

import java.util.concurrent.ThreadLocalRandom;

public class GameGrid {
	
	private String[] cardValues = {"Affe","Hund","Tiger","Löwe","Yak","Dachs","Pferd","Kuh"};
	private MemoryCard[][]cards = new MemoryCard[4][4];
	
	
	private void placeCards(String value){
		
		
		//for(int i=0; i<8; i++){
			
			int x1=0;
			int y1=0;
			
			int x2=0;
			int y2=0;
			
			for(int k=0; k<2; k++){
				
				int x = ThreadLocalRandom.current().nextInt(0,(cardValues.length/2));
				int y = ThreadLocalRandom.current().nextInt(0,(cardValues.length/2));
				
				if(k==0){
					x1 = x;
					y1 = y;
				}else if(k==1 && (x!=x1 || y!=y1)){
					x2 = x;
					y2 = y;
					
					
					if(cards[x1][y1]==null && cards[x2][y2]==null){
						cards[x1][y1]= new MemoryCard(value);
						cards[x2][y2]= new MemoryCard(value);
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
	
	public MemoryCard getCard(int x, int y){
		return cards[x][y];
	}
	
	public boolean isGameOver(){
		
		for(MemoryCard[] cardsCheck : cards){
			
			for(MemoryCard card : cardsCheck){
				
				if(card.getState() == MemoryCard.state.UNSOLVED){
					return false;
				}
				
			}
			
		}
		
		return true;
	}
	
	public MemoryCard[][] getCards(){
		return cards;
	}

}
