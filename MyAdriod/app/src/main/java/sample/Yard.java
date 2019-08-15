package sample;
import java.util.ArrayList;
import java.util.List;

public class Yard {
    public int width;
    public int height;

    public List<Position> beans = new ArrayList();

    public Yard(int w, int h){
        this.width = w;
        this.height = h;
    }

    public void addBeans(int count){
        for(int i=0;i<count;i++){
            int beanX = (int)(Math.random()*this.width);
            int beanY = (int)(Math.random()*this.height);
            if(beanX!=0 & beanY!=0) {
                beans.add(new Position(beanX, beanY));
            }
        }
    }
}


