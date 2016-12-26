package gameobjects;

import Base.Property;
import abstractobjects.GameObject;

/**
 * PROPERTIES :
 * [0] : "type" : type
 */
class Point extends GameObject {

    private static final String[] PROPERTIES = { "type" };

    private String type;

    Point(String type) {
        this.type = type;
    }

    public String getTexture() {
        if (type.equals("ENTRY"))
            return "entry.png";
        return "exit.png";
    }

    @Override
    public void editProperty(Property property) {
        if (!property.getName().equals(PROPERTIES[0]))
            return;

        type = property.getValue();
    }

    @Override
    public Property[] getProperties() {
        return new Property[]{ new Property(PROPERTIES[0], type) };
    }
}
