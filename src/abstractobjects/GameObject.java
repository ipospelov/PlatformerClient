package abstractobjects;
import Base.Property;
import mfc.GameObjectForController;
import mfv.GameObjectForView;


public abstract class GameObject implements GameObjectForController,
        GameObjectForView {

    private String texture;

//    texture

    @Override
    public void setTexture(String texture) {
        this.texture = texture;
    }

    @Override
    public String getTexture() {
        return texture;
    }


//    properties

    @Override
    public abstract void editProperty(Property property);

    @Override
    public abstract Property[] getProperties();
}