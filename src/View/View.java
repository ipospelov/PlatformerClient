package View;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by posiv on 26.12.16.
 */
public class View {
    private Pane appRoot;
    private Pane gameRoot;
    private Stage primaryStage;
    public static Scene scene;
    private ArrayList<Block> blocks;
    private Character character;
    private BackgroundImage myBI;
    public static int windowWidth = 1000;
    public static int windowHeight = 400;
    public static int objectWidth = 20;
    public static int objectHeight = 20;
    private Block currentBlock;


    public View(Stage primaryStage){
        this.primaryStage = primaryStage;
        scene = new Scene(createContent());
        blocks = new ArrayList<>();

    }

    private Parent createContent(){
        appRoot = new Pane();
        gameRoot = new Pane();
        gameRoot.setPrefSize(windowWidth,windowHeight);
        appRoot.getChildren().add(gameRoot);
        return appRoot;
    }

    public void addBlock(int relativeX, int relativeY, String file){
        Block block = new Block(relativeX * objectWidth, relativeY * objectHeight, file);
        blocks.add(block);
        gameRoot.getChildren().addAll(block);
    }

    public void setBackgroud(String file){
        myBI= new BackgroundImage(new Image("file:"+file),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        gameRoot.setBackground(new Background(myBI));
    }

    public void addCharacter(String file){ //default coord: 1,0
        character = new Character(file);
        gameRoot.getChildren().addAll(character);
    }

    public Scene getScene(){
        return scene;
    }

    public int getCharacterX(){
        return character.x;
    }
    public int getCharacterY(){
        return character.y;
    }
    public void setCharacterX(int x){
        character.setCoords(x, character.y);
    }

    public Pane getCharacter() {
        return character;
    }

    public void setCharacterY(int y){
        character.setCoords(character.x, y);
    }

    public boolean overBlockByY(int x, int y){
        for (Block array : blocks){
            if((x + View.objectWidth >= array.rect.getX() && x <= (array.rect.getX() + View.objectWidth)) &&
             (y + View.objectHeight >= array.rect.getY() && y + View.objectHeight <= array.rect.getY() + View.objectHeight)){
                currentBlock = array;
                return true;
            }
        }
        return false;
    }

    public boolean overBlockByRightX(int x, int y){
        for (Block array : blocks){
            if((x + View.objectWidth >= array.rect.getX() && x + View.objectWidth <= array.rect.getX() + View.objectWidth)
                    && character.rect.intersects(array.rect.getX(),array.rect.getY() + 5, View.windowWidth, View.objectHeight - 5))
            {
                return true;
            }
        }
        return false;
    }

    public boolean overBlockByLeftX(int x, int y){
        for (Block array : blocks){
            if((x  <= array.rect.getX() + View.objectWidth && x >= array.rect.getX())
                    && character.rect.intersects(array.rect.getX(),array.rect.getY() + 5, View.windowWidth, View.objectHeight - 5))
            {
                return true;
            }
        }
        return false;
    }

    public Block getCurrentBlock(){
        return currentBlock;
    }

}
