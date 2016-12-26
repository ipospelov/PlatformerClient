package gameobjects;

import abstractobjects.GameObject;
import abstractobjects.GameObjectAbstractFactory;

public class CharacterFactory extends GameObjectAbstractFactory.GameObjectFactory {

    public static final String TYPE = "character";

    static {
        new CharacterFactory().subscribe(TYPE);
    }

    @Override
    protected GameObject getGameObject(String[] attributes) {
        return new Character(attributes);
    }
}
