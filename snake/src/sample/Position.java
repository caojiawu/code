package sample;

public class Position {
    public int x;
    public int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return this.x == ((Position) obj).x & this.y == ((Position) obj).y;
    }
}
