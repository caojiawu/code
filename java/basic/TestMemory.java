package basic;

public class TestMemory {
    public static void main(String[] args){
        testMemoryAllocate();
    }

    //bullshit memory allocation mechanism, this lead to confusion.
    public static void testMemoryAllocate(){
        Integer a1 = 33;
        Integer a2 = 33;
        System.out.println(a1==a2); //Integer类型取值在[-128,127]范围，内存为中常量池分配

        Integer b1 = 330;
        Integer b2 = 330;
        System.out.println(b1==b2); //Integer类型取值不在[-128,127]范围，对象为在堆中分配
    }
}
