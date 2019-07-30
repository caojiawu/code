package sample;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Snake {
    private int status = 0; //0:alive,1:collided
    public Yard yard;

    private int pointHeadX;
    private int pointHeadY;
    private List<Segment> segmentList = new ArrayList();

    public Snake(Yard yard){
        this.yard = yard;
        this.pointHeadX = this.yard.width/2;
        this.pointHeadY = this.yard.height/2;

        Segment seg = new Segment(15,DIRECTION.up);
        segmentList.add(seg);

        List<Position> snakePos = getPositions();
        Iterator<Position> it = yard.beans.iterator();
        while (it.hasNext()){
            Position p = it.next();
            if (snakePos.contains(p)){
                it.remove();
            }
        }
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
        return DIRECTION.up;
    }

    public void changeDirection(DIRECTION direction){
        //if the new direction is same, or is opposite of head segment
        Segment headSegment = segmentList.get(0);
        if((direction == headSegment.direction) | (headSegment.direction == getOpposite(direction))){
            return;
        }else{
            //add new segment or change direction of a never moving segment
            if(headSegment.length == 0){
                headSegment.direction = direction;
            }else{
                segmentList.add(0,new Segment(0,direction));
            }
        }
    }

    //return false if collided toward obstacle.
    public void move(){
        if(this.status == 1) {
            this.yard.addBeans(100);
            return;
        }

        //check whether collide
        Segment headSegment = segmentList.get(0);
        int newPointHeadX = this.pointHeadX;
        int newPointHeadY = this.pointHeadY;

        switch (headSegment.direction){
            case up:
                newPointHeadY = newPointHeadY -1;
                break;
            case down:
                newPointHeadY = newPointHeadY + 1;
                break;
            case left:
                newPointHeadX = newPointHeadX - 1;
                break;
            case right:
                newPointHeadX = newPointHeadX + 1;
                break;
        }

        //check whether collide with the wall
        if(newPointHeadY <= 0 | newPointHeadY >= yard.height | newPointHeadX <= 0 | newPointHeadX >= yard.width){
            this.status = 1;
            return;
        }
        //check whether collide with himself
        if(getPositions().contains(new Position(newPointHeadX, newPointHeadY))){
            this.status = 1;
            return;
        }

        //eat bean or keep moving
        Boolean eatFlag = false;
        if(this.yard.beans.contains(new Position(newPointHeadX,newPointHeadY))){
            eatFlag = true;
            this.yard.beans.remove(new Position(newPointHeadX,newPointHeadY));
        }

        if(headSegment.length != 0) {
            this.pointHeadX = newPointHeadX;
            this.pointHeadY = newPointHeadY;
        }

        headSegment.length = headSegment.length + 1;
        if(eatFlag == Boolean.FALSE){
            Segment lastSegment = segmentList.get(segmentList.size() - 1);
            if (lastSegment.length == 1) {
                segmentList.remove(segmentList.size() - 1);
            } else {
                lastSegment.length = lastSegment.length - 1;
            }
        }
    }

    public ArrayList getPositions(){
        ArrayList positionList = new ArrayList();
        int tmpSegmentX = this.pointHeadX;
        int tmpSegmentY = this.pointHeadY;
        positionList.add(new Position(this.pointHeadX, this.pointHeadY));
        for(Segment segment:segmentList){
            //System.out.println(segment);
            if(segment.length > 0){
                for(int i = 1; i < segment.length; i++){
                    switch (segment.direction){
                        case up:
                            positionList.add(new Position(tmpSegmentX, tmpSegmentY + 1));
                            tmpSegmentY = tmpSegmentY + 1;
                            break;
                        case down:
                            positionList.add(new Position(tmpSegmentX, tmpSegmentY - 1));
                            tmpSegmentY = tmpSegmentY - 1;
                            break;
                        case left:
                            positionList.add(new Position(tmpSegmentX + 1, tmpSegmentY));
                            tmpSegmentX= tmpSegmentX + 1;
                            break;
                        case right:
                            positionList.add(new Position(tmpSegmentX - 1, tmpSegmentY));
                            tmpSegmentX = tmpSegmentX - 1;
                            break;
                    }
                }
            }
        }
        return positionList;
    }
}

