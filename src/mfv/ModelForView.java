
package mfv;

import java.util.Observer;

public interface ModelForView {

	String getDefaultLocation();

	ProjectForView getCurrentProject();

    void addObserver(Observer o);

    void deleteObserver(Observer o);
}
