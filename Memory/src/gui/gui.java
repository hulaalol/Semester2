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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
	static Image[] cardPictures = new Image[9];
	
	static{
		cardPictures[0] = new Image("file:/stud/mh252/git/Semester2.1/Memory/src/gui/Dachsnormal.png");
		cardPictures[1] = new Image("file:/stud/mh252/git/Semester2.1/Memory/src/gui/loewe.png");
		cardPictures[2] = new Image("file:/stud/mh252/git/Semester2.1/Memory/src/gui/monkey.png");
		cardPictures[3] = new Image("file:/stud/mh252/git/Semester2.1/Memory/src/gui/doge.png");
		
		cardPictures[4] = new Image("file:/stud/mh252/git/Semester2.1/Memory/src/gui/horse.png");
		cardPictures[5] = new Image("file:/stud/mh252/git/Semester2.1/Memory/src/gui/yak.png");
		cardPictures[6] = new Image("file:/stud/mh252/git/Semester2.1/Memory/src/gui/cow.png");
		cardPictures[7] = new Image("file:/stud/mh252/git/Semester2.1/Memory/src/gui/tiger.png");
		cardPictures[8] = new Image("file:/stud/mh252/git/Semester2.1/Memory/src/gui/back.png");

	}
	

	
	
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
			field[i] = new Button();
			field[i].setGraphic(new ImageView(cardPictures[8]));
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
						
					
						//tmp.setText(grid.getCard(index).getValue());
						setButtonGraphic(tmp, grid.getCard(index).getValue());
						//tmp.setGraphic(new ImageView(cardPictures[index]));
						
						tmp.setText("");
						
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
			field[i].setGraphic(new ImageView(cardPictures[8]));
		}
		}

	}
	
	public static void setButtonGraphic(Button btn, String text){
		
		switch (text){
		
		case "Dachs":
			btn.setGraphic(new ImageView(cardPictures[0]));
			
		break;
			
		case "Löwe":
			btn.setGraphic(new ImageView(cardPictures[1]));
		break;
			
		case "Yak":
			btn.setGraphic(new ImageView(cardPictures[5]));
			break;
		case "Hund":
			btn.setGraphic(new ImageView(cardPictures[3]));
			break;
		case "Affe":
			btn.setGraphic(new ImageView(cardPictures[2]));
			break;
		case "Pferd":
			btn.setGraphic(new ImageView(cardPictures[4]));
			break;
		case "Tiger":
			btn.setGraphic(new ImageView(cardPictures[7]));
			break;
		case "Kuh":
			btn.setGraphic(new ImageView(cardPictures[6]));
			break;
		default:
			break;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		launch(args);

		
		
	}

}
