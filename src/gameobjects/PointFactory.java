package gameobjects;


import abstractobjects.GameObject;
import abstractobjects.GameObjectAbstractFactory;

public class PointFactory extends GameObjectAbstractFactory.GameObjectFactory {

    public static final String TYPE = "point";

    static {
        new PointFactory().subscribe(TYPE);
    }

    @Override
    protected GameObject getGameObject(String[] attributes) {
        return new Point(attributes[0]);
    }
}
