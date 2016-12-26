package mfc;


public interface ProjectForController {

	void setName(String name);

	void addMediaFile(String name);

	void removeMediaFile(String name);

	void addLevel(String name, int pos);

	void removeLevel(int pos);

	void replaceLevel(int oldPos, int newPos);

	LevelForController getLevel(int pos);

}
