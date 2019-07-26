package sample;
import java.util.List;

public class Snake {


    public int pointBeginX;
    public int pointBeginY;
    public List<Segment> segmentList;

    public Snake(Yard yard){
        this.pointBeginX = yard.width/2;
        this.pointBeginY = yard.height/2;

        Segment seg = new Segment();
        segmentList.add(seg);
    }

    public DIRECTION getOpposite(DIRECTION direction){
        switch (direction){
            case up:
                return  DIRECTION.down;
            case down:
                return DIRECTION.up;
            case left:
                return DIRECTION.right;
            case right:
                return DIRECTION.left;
        }
    }

    public void move(DIRECTION direction){
        //if the new direction is the opposite of last segment, do nothing
        if((direction!=DIRECTION.keep) &
            (segmentList.get(segmentList.size()-1)).direction == getOpposite(direction)){
            move(DIRECTION.keep);
        }else if(direction == DIRECTION.keep){
            //todo: check whether there is obstacle or bean ahead

            //check remove the first segment or shorten it
            Segment lastSegment = segmentList.get(segmentList.size()-1);
            lastSegment.length = lastSegment.length + 1;

        }else{
            //add new segment
        }
    }

    public check
}
