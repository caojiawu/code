package basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBasicType {
    public static void main(String[] args){
        StringBuffer a = new StringBuffer("abc");
        StringBuffer b = a;
        b.append('f');
        System.out.println(a);

        TestBasicType obj = new TestBasicType();
        obj.testArrayList();


    }
    public void testArrayList(){
        String[] arr = {"aaa","bbb","ccc"};

        //test case 1:
        List<String> myList = Arrays.asList(arr);

        //myList.add("ddd"); // exception for the object behind myList is still a Array not support add method

        //test case 2 compared with test case 1
        //List myList = new ArrayList();
        //myList.add("ddd");
        System.out.println(myList);

        List list = new ArrayList(Arrays.asList(arr)); //build generic ArrayList
        list.add("hello");
        list.add("world");
        System.out.println(list);

    }

    public void testBasicType(){
        BigDecimal a = new BigDecimal(1.0);
        BigDecimal b = new BigDecimal(0.9);
        BigDecimal c = new BigDecimal(0.8);
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);
        System.out.println(x.equals(y));

        //精度丢失
        float x1 = 1.0f - 0.9f;
        float x2 = 0.9f - 0.8f;
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x1==x2);
    }
}
