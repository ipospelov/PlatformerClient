
package mfv;

import Base.Coord;

import java.util.Map;
import java.util.Observer;

public interface LevelForView {

	String getName();

	int getHeight();

	int getWidth();

	Map<Coord, String> getGameObjects();

    String getTheme();

    String getBackground();

    void addObserver(Observer o);

    void deleteObserver(Observer o);
}
