package sample;

public class Controller {
    private int offsetX;
    private int offsetY;
    public Controller(){
        offsetX = 3;
        offsetY = 3;
    }
    public int handleRight(int x){
       return x + offsetX;
    }

    public int handleLeft(int x){
        return x - offsetX;
    }
}
