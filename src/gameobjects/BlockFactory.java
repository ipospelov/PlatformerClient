package gameobjects;

import abstractobjects.GameObject;
import abstractobjects.GameObjectAbstractFactory;

public class BlockFactory extends GameObjectAbstractFactory.GameObjectFactory {

    public static final String TYPE = "block";

    static {
        new BlockFactory().subscribe(TYPE);
    }

    @Override
    protected GameObject getGameObject(String[] attributes) {
        return new Block(attributes[0]);
    }
}
