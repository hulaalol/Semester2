package gui;

import impl.GameGrid;
import impl.MemoryCard;
import impl.MemoryGame;
import interfaces.MemoryCardInterface;
import interfaces.MemoryCardInterface.state;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class gui extends Application{

	//start a game
	public MemoryGame game = new MemoryGame();
	public GameGrid grid = game.grid;
	MemoryCard[] flipped = new MemoryCard[2];
	static Button[] field = new Button[16];
	int flippedCounter=0;
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//graphic ui
		StackPane root = new StackPane();

		Scene scene = new Scene(root,800,800);
		
		primaryStage.setMaxHeight(800D);
		primaryStage.setMaxWidth(800D);
		
		primaryStage.setMinHeight(200D);
		primaryStage.setMinWidth(200D);
		
		//setup buttons
		
		for(int i=0; i<field.length; i++){
			field[i] = new Button(""+(i+1));
			field[i].setMaxSize(200D, 200D);
			field[i].setPrefSize(200D, 200D);
			field[i].setMinSize(10D, 10D);
			
			Button tmp = field[i];
			int index = i;
			
			
			
			//handle button clicks
			field[i].setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					
				if(grid.getCard(index).locked){
					
				}else if(grid.getCard(index).getState()==MemoryCardInterface.state.UNSOLVED){
						
						if(flippedCounter==2){
							flippedCounter = 0;
							refreshGui(grid);
						}
						
					
						tmp.setText(grid.getCard(index).getValue());
						grid.getCard(index).setState(state.VISIBLE);
						
						flipped[flippedCounter]=grid.getCard(index);
						
						
						if(flippedCounter==1){
							
							if(flipped[0].equals(flipped[1])){
								flipped[0].setState(state.SOLVED);
								flipped[0].locked = true;
								
								flipped[1].setState(state.SOLVED);
								flipped[1].locked = true;
							}else{
								
								
							}
							
						}
						
						flippedCounter++;
	
					}else if(grid.getCard(index).getState()==MemoryCardInterface.state.SOLVED){
						//do nothing
					}else{
						//do nothing
					}
					
					
					
				}
			});

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		//Graphic UI
		HBox[] rows = new HBox[4];
		for(int i=0; i<rows.length; i++){
			rows[i]= new HBox();
		}
		
		int fIndex = 0;
		for(HBox row : rows){
			int i = 0;
			while(i<4){
				row.getChildren().add(field[fIndex]);
				fIndex++;
				i++;
			}
	
		}
		
		VBox vertical = new VBox();
	
		for(HBox rowTest : rows){
			vertical.getChildren().add(rowTest);
		}
		
		root.getChildren().add(vertical);
		
		primaryStage.setTitle("Memory");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
		
		
		
		
	}
	
	
	public static void refreshGui(GameGrid grid){

		for(int i=0; i<16; i++){
			
		if(grid.getCard(i).getState()==MemoryCardInterface.state.VISIBLE){
			grid.getCard(i).setState(state.UNSOLVED);
			field[i].setText(""+(i+1));
		}
		}

	}
	
	
	public static void main(String[] args) {
		launch(args);
		
		
		
		
		
		
		
		
	}

}
