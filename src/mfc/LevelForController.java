package mfc;


import Base.Coord;

public interface LevelForController {

	void setName(String name);

	void setHeight(int height);

	void setWidth(int width);

	void addGameObject(String type, Coord coord, String[] attributes);

	void removeGameObject(Coord coord);

	void replaceGameObject(Coord oldCoord, Coord newCoord);

	GameObjectForController getGameObject(Coord coord);

    void setTheme(String theme);

    void setBackground(String background);
}
