package basic;

import java.util.*;

public class TestCollection {
    public TreeSet treeSet;
    public ArrayList arrayList;
    public Vector vector;
    public HashSet hashSet;
    public LinkedList linkedList;
    public LinkedHashSet linkedHashSet;
    public Stack stack;

    public static void main(String[] args){
        TestCollection testObj = new TestCollection();
        testObj.arrayList = new ArrayList();
        testObj.arrayList.add(1);
        testObj.arrayList.add(new Hashtable<Integer,String>());
        System.out.println(testObj.arrayList);


        HashMap hashMap = new HashMap();
        Hashtable hashtable = new Hashtable();

    }
}
