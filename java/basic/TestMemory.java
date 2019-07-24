package basic;

public class TestMemory {
    public static void main(String[] args){
        testMemoryAllocate();

    }

    //bullshit memory allocation mechanism, this lead to confusion.
    public static void testMemoryAllocate(){
        Integer a1 = 33;
        Integer a2 = 33;
        System.out.println(a1==a2); //True. Integer类型取值在[-128,127]范围，栈中分配并查找一个已经存在的对象

        Integer b1 = 330;
        Integer b2 = 330;
        System.out.println(b1==b2); //False. Integer类型取值不在[-128,127]范围，栈中直接创建一个新的对象

        int c1 = 330;
        int c2 = 330;
        System.out.println(c1==c2); //True. 基本类型，直接比对取值

        String d1 = "hello world";
        String d2 = "hello world";
        System.out.println(d1==d2); //True. 对于在栈中分配的字符串，直接查找已经存在的对象并返回.

        String e1 = new String("hello world");
        String e2 = new String("hello world");
        System.out.println(e1==e2); //False. 在堆上分配的对象，每次地址均不同.

        double f1 = 330.0;
        double f2 = 330.0;
        System.out.println(f1==f2); //True.
    }
}
