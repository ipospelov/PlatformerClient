package sample;

public class Controller {
    private int offsetX;
    private int offsetY;
    public static int iterationsAfterPush = 0;
    public Controller(){
        offsetX = 3;
        offsetY = 10;
    }
    public int handleRight(int x){
       return x + offsetX;
    }

    public int handleLeft(int x){
        return x - offsetX;
    }

    public void setZeroGravity(){
        iterationsAfterPush = 0;
    }

    public void setFullGravity(){
        iterationsAfterPush = 10;
    }
    public int handleUp(int y){
        int yOff = y - (offsetY - iterationsAfterPush);
        iterationsAfterPush++;
        return yOff;
    }
}
