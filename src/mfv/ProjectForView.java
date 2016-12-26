package mfv;

import java.util.Observer;

public interface ProjectForView {

	String getName();

	String[] getMediaFiles();

	String[] getLevels();

	LevelForView getLevel(int pos);

    void addObserver(Observer o);

    void deleteObserver(Observer o);
}
