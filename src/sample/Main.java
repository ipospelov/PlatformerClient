package sample;

import Model.Model;
import View.View;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {
    private HashMap<KeyCode,Boolean> keys = new HashMap<>();
    View gameView;
    Controller gameController;
    Model gameModel;
    @Override
    public void start(Stage primaryStage) throws Exception{
        String location = "/home/posiv/НГУ/ОАД/test/";
         gameView = new View(primaryStage);
         gameController = new Controller();
         gameModel = new Model(location, gameController, gameView);

        gameModel.openProject("test1.platformer",location);
        gameModel.setBackground();
        gameModel.loadBlocks();
        gameModel.loadCharacter();


        primaryStage.setScene(gameView.getScene());
        primaryStage.show();

        gameView.getScene().setOnKeyPressed(event-> keys.put(event.getCode(), true));
        gameView.getScene().setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
        });


        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        animationTimer.start();
        
    }

    private boolean isPressed(KeyCode key){
        return keys.getOrDefault(key,false);
    }

    public void update(){

        if(isPressed(KeyCode.RIGHT) && !gameView.overBlockByRightX(gameView.getCharacterX(), gameView.getCharacterY())) {
            gameView.setCharacterX( gameController.handleRight(gameView.getCharacterX()) );
        }

        if(isPressed(KeyCode.LEFT) && !gameView.overBlockByLeftX(gameView.getCharacterX(), gameView.getCharacterY())) {
            gameView.setCharacterX( gameController.handleLeft(gameView.getCharacterX()) );
        }

        if(isPressed(KeyCode.UP) || gameController.iterationsAfterPush > 0) {
            gameView.setCharacterY( gameController.handleUp(gameView.getCharacterY()) );
        }

        if(gameView.getCharacterY() - 1 >= View.windowHeight - View.objectHeight) {
            gameController.setZeroGravity();
            gameView.setCharacterY(View.windowHeight - View.objectHeight);
        }

        if(gameView.overBlockByY(gameView.getCharacterX(),gameView.getCharacterY())) {
                gameController.setZeroGravity();
        }else if(gameController.iterationsAfterPush == 0 && gameView.getCharacterY() < View.windowHeight - View.objectHeight)
            gameController.setFullGravity();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
