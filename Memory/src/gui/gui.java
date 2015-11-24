package gui;

import impl.GameGrid;
import impl.MemoryCard;
import impl.MemoryGame;
import interfaces.MemoryCardInterface;
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

	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		MemoryGame game = new MemoryGame();
		GameGrid grid = game.grid;
		
		MemoryCard[] list = new MemoryCard[16];
		
		int listindex = 0;
		for(int i=0; i<4; i++){
			
			for(int k=0; k<4; k++){
				
					list[listindex] = game.grid.getCard(i, k);
					listindex++;
				
				
			}
			
			
			
		}
		
		
		
		StackPane root = new StackPane();
		
		Scene scene = new Scene(root,800,800);
		
		primaryStage.setMaxHeight(800D);
		primaryStage.setMaxWidth(800D);
		
		primaryStage.setMinHeight(200D);
		primaryStage.setMinWidth(200D);
		


		
		Button[] field = new Button[16];
		for(int i=0; i<field.length; i++){
			field[i] = new Button(""+(i+1));
			field[i].setMaxSize(200D, 200D);
			field[i].setPrefSize(200D, 200D);
			field[i].setMinSize(10D, 10D);
			
			Button tmp = field[i];
			int index = i;
			
			field[i].setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					
					if(list[index].getState()==MemoryCardInterface.state.UNSOLVED){
						tmp.setText(list[index].getValue());
					}else{
						tmp.setText(""+index);
					}
					
					
					
				}
			});

		}

		
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
	
	public static void main(String[] args) {
		launch(args);
	}

}
