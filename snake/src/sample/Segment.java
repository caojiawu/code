package sample;

public class Segment{
    public int length; //length is maybe 0 while turn direction.
    public DIRECTION direction;

    public Segment(int len, DIRECTION direction){
        this.length = len;
        this.direction = direction;
    }
}