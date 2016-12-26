package gameobjects;

import Base.Property;
import abstractobjects.GameObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PROPERTIES :
 * [0] : "texture0" : textures.get(0);
 * [1] : "texture1" : textures.get(1);
 * [2] : "texture2" : textures.get(2);
 */
class Character extends GameObject {

    private static final String[] PROPERTIES = { "texture0",
                                                 "texture1",
                                                 "texture2" };

	private List<String> textures = new ArrayList<>(3);

    Character(String[] textures) {
        this.textures = Arrays.asList(textures);
    }

//    texture

    @Override
    public String getTexture() {
        if (textures.isEmpty())
            return null;

        return textures.get(0);
    }

    //    properties

    @Override
    public void editProperty(Property property) {
        int pos = Integer.decode(property.getName().split("testure")[0]);

        textures.remove(pos);
        textures.add(pos, property.getValue());
    }

    @Override
    public Property[] getProperties() {
        return new Property[]{ new Property(PROPERTIES[0], textures.get(0)),
                               new Property(PROPERTIES[1], textures.get(1)),
                               new Property(PROPERTIES[2], textures.get(2)) };
    }
}
