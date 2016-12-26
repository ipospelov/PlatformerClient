package Model;

import Base.Coord;
import View.View;
import abstractobjects.Parser;
import abstractobjects.Project;
import gameobjects.BlockFactory;
import gameobjects.CharacterFactory;
import gameobjects.PointFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class Model {
    private Project currentProject;
    private String location;
    private View gameView;
    private Controller gameController;
    private int currentLevelNumber;
    private int amountOfLevels;

    public Model(String location, Controller gameController, View gameView){
        this.location = location;
        this.gameController = gameController;
        this.gameView = gameView;
        currentLevelNumber = 0;
        amountOfLevels = -1;
        new BlockFactory();
        new CharacterFactory();
        new PointFactory();

    };
    public void openProject(String fileName, String location) throws FileNotFoundException {
        currentProject = Parser.getProject(new FileInputStream(location + fileName));

        String levels[] = currentProject.getLevels();
        for (String level : levels) {
            currentProject.removeLevel(0);
            currentProject.addLevel(Parser.getLevel(new FileInputStream(location + level)));
            amountOfLevels++;
        }
    }

    public void loadCharacter(){
        Map<Coord,String> map = currentProject.getLevel(currentLevelNumber).getGameObjects();
        for(Map.Entry<Coord, String> entry : map.entrySet()){
            if (entry.getKey().equals(new Coord(1, 0))) {
                gameView.addCharacter(location + entry.getValue());
                break;
            }
        }
    }

    public void setBackground(){
        String[] media = currentProject.getMediaFiles();
        if(media[0] != null){
            gameView.setBackgroud(location + media[0]);
        }
    }

    public void loadBlocks(){
        Map<Coord,String> map = currentProject.getLevel(currentLevelNumber).getGameObjects();
        for(Map.Entry<Coord, String> entry : map.entrySet()){
            if( !entry.getValue().equals("entry.png") && !entry.getValue().equals("exit.png")) {
                if (!entry.getKey().equals(new Coord(1, 0)))
                    gameView.addBlock(entry.getKey().getX(), entry.getKey().getY(), location + entry.getValue());
            }
            //System.out.println(entry.getKey().getX() + entry.getKey().getY());
            //System.out.println(amountOfLevels);
        }
    }

    public void handleRightKey(){
        gameView.setCharacterX( gameController.handleRight(gameView.getCharacterX()));
    }
}
