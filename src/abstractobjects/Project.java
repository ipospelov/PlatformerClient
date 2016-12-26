package abstractobjects;

import mfc.ProjectForController;
import mfv.ProjectForView;

import java.util.*;

public class Project extends Observable
                     implements ProjectForView,
        ProjectForController {

	private String name;

	private List<Level> levels = new LinkedList<>();
    private Set<String> mediaFiles = new HashSet<>();

    public Project(String name) {
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

//    levels

    void addLevel(String name) {
        levels.add(new Level(name));
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    @Override
    public void addLevel(String name, int pos) {
        levels.add(pos, new Level(name));

        notifyObservers();
    }

    @Override
    public void removeLevel(int pos) {
        levels.remove(pos);

        notifyObservers();
    }

    @Override
    public void replaceLevel(int oldPos, int newPos) {
        Level level = levels.remove(oldPos);
        levels.add(newPos, level);

        notifyObservers();
    }

    @Override
	public String[] getLevels() {
		return levels.stream().map(Level::getName).toArray(String[]::new);
	}

    @Override
	public Level getLevel(int pos) {
        return levels.get(pos);
    }

//    mediaFiles

    @Override
    public void addMediaFile(String name) {
        mediaFiles.add(name);

        notifyObservers();
    }

    @Override
	public void removeMediaFile(String name) {
        mediaFiles.remove(name);

        notifyObservers();
	}

    @Override
    public String[] getMediaFiles() {
        return mediaFiles.toArray(new String[mediaFiles.size()]);
    }

    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }
}