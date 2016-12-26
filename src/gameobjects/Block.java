package gameobjects;


import Base.Property;
import abstractobjects.GameObject;

/**
 * PROPERTIES :
 * [0] : "texture" : texture
 */
class Block extends GameObject {

    private static final String[] PROPERTIES = { "texture" };

    Block(String texture) {
        setTexture(texture);
    }

    //    properties

    @Override
    public void editProperty(Property property) {
        if (!property.getName().equals(PROPERTIES[0]))
            return;

        setTexture(property.getValue());
    }

    @Override
    public Property[] getProperties() {
        return new Property[]{ new Property(PROPERTIES[0], getTexture()) };
    }
}
