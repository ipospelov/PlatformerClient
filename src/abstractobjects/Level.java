package abstractobjects;


import Base.Coord;
import mfc.GameObjectForController;
import mfc.LevelForController;
import mfv.LevelForView;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.stream.Collectors;

public class Level extends Observable
                   implements LevelForController,
        LevelForView {

    private static final int DEFAULT_HEIGHT = 20;
    private static final int DEFAULT_WIDTH  = 40;

	private String name;

    private int width = DEFAULT_WIDTH;
	private int height = DEFAULT_HEIGHT;

    private GameObjectAbstractFactory factory = new GameObjectAbstractFactory();
	private Map<Coord, GameObject> gameObjects = new HashMap<>();

	private String theme;
	private String background;

    Level(String name) {
        this.name = name;
    }

//    name

    @Override
	public void setName(String name) {
        this.name = name;
	}

    @Override
    public String getName() {
        return name;
    }

//    height

    @Override
	public void setHeight(int height) {
        this.height = height;

        notifyObservers();
	}

    @Override
    public int getHeight() {
        return height;
    }

//    width

    @Override
	public void setWidth(int width) {
        this.width = width;

        notifyObservers();
	}

    @Override
    public int getWidth() {
        return width;
    }

//    gameObjects

    @Override
	public void addGameObject(String type, Coord coord, String[] attributes) {
        if (gameObjects.containsKey(coord))
            return;

        gameObjects.put(coord, factory.getGameObject(type, attributes));

        notifyObservers();
	}

    @Override
	public void removeGameObject(Coord coord) {
        gameObjects.remove(coord);

        notifyObservers();
	}

    @Override
	public void replaceGameObject(Coord oldCoord, Coord newCoord) {
        if (gameObjects.containsKey(newCoord))
            return;

        GameObject obj = gameObjects.remove(oldCoord);
        gameObjects.put(newCoord, obj);

        notifyObservers();
	}

    @Override
	public GameObjectForController getGameObject(Coord coord) {
		return gameObjects.get(coord);
	}

    @Override
	public Map<Coord, String> getGameObjects() {
        return gameObjects.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getTexture()));
	}

//    theme

    @Override
    public void setTheme(String theme) {
        this.theme = theme;

        notifyObservers();
    }

    @Override
    public String getTheme() {
        return theme;
    }

//    background

    @Override
    public void setBackground(String background) {
        this.background = background;

        notifyObservers();
    }

    @Override
    public String getBackground() {
        return background;
    }

    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }
}
