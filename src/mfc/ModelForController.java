package mfc;

import java.io.FileNotFoundException;

public interface ModelForController {

	void setDefaultLocation(String defaultLocation);

    void openProject(String fileName, String location) throws FileNotFoundException;

    void createProject(String name);

	ProjectForController getCurrentProject();
}
