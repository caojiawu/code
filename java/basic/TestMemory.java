package basic;

public class TestMemory {
    public static void main(String[] args){
        testMemoryAllocate();

    }

    public static void testMemoryAllocate(){
        Integer a1 = 33;
        Integer a2 = 33;
        System.out.println(a1==a2); //True. Integer类型取值在[-128,127]范围，栈中分配并查找一个已经存在的对象

        //bullshit memory allocation mechanism, this lead to confusion.
        //including Byte, Short, Integer, Long, Character and Boolean, except for Float and Double.
        Integer b1 = 330;
        Integer b2 = 330;
        System.out.println(b1==b2); //False. Integer类型取值不在[-128,127]范围，栈中直接创建一个新的对象

        Double f1 = 30.0;
        Double f2 = 30.0;
        System.out.println(f1==f2); //False.

        int c1 = 330;
        int c2 = 330;
        System.out.println(c1==c2); //True. 基本类型，直接比对取值

        String d1 = "hello world1";
        String d2 = "hello world1";
        System.out.println(d1==d2); //True. 对于在栈中分配的字符串，直接查找已经存在的对象并返回.

        String e1 = new String("hello world");
        String e2 = new String("hello world");
        System.out.println(e1==e2); //False. 在堆上分配的对象，每次地址均不同

        String g1 = "Str"+"ing";
        String g2 = "Str";
        String g3 = "ing";
        String g4 = "String";
        System.out.println(g1==g4);//True
        System.out.println((g2+g3)==g4);//False, temporary object differs.

        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2 " + (i1 == i2));
        System.out.println("i1=i2+i3 " + (i1 == i2 + i3));
        System.out.println("i1=i4 " + (i1 == i4));
        System.out.println("i4=i5 " + (i4 == i5));

        //i5+i6 is lookded as two int variable operation, since the object addition is not definite.
        //so finally there are tow int variable compared, then the result is true.
        System.out.println("i4=i5+i6 " + (i4 == i5 + i6)); //true
        System.out.println("40=i5+i6 " + (40 == i5 + i6)); //true

    }
}
