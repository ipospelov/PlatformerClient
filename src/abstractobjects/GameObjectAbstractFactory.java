package abstractobjects;

import java.util.HashMap;
import java.util.Map;

public class GameObjectAbstractFactory {

	static private Map<String, GameObjectFactory> factories = new HashMap<>();

	GameObject getGameObject(String type, String[] attributes) {
        return factories.get(type).getGameObject(attributes);
    }

	public static abstract class GameObjectFactory {

		abstract protected GameObject getGameObject(String[] attributes);

		protected void subscribe(String type) {
            GameObjectAbstractFactory.factories.put(type, this);
        }
	}
}
