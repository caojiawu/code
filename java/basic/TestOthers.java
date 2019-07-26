package basic;

public class TestOthers {

    public int a;

    public static void main(String[] args){
        TestOthers tmp = new TestOthers();
        tmp.a = 200;
        setValue(tmp);
        System.out.println(tmp.a);
    }

    public static void setValue(TestOthers obj){
        obj.a = 100;
    }
}
