package basic;
import java.util.List;
import java.util.ArrayList;

public class TestOthers {

    public int x;
    public int y;
    public TestOthers(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.x == ((TestOthers)obj).x & this.y == ((TestOthers)obj).y){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        List<TestOthers> l = new ArrayList();
        for(int i=0;i<6;i++){
            l.add(new TestOthers(i,i));
        }

        System.out.println(l);
    }


}
