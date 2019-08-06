public class Singleton
{
    private static volatile Singleton instance=null;    //保证 instance 在所有线程中同步
    private Singleton(){}    //private 避免类在外部被实例化

    private int a = 0;
    public static synchronized Singleton getInstance()
    {
        //getInstance 方法前加同步
        if(instance==null)
        {
            instance=new Singleton();
        }
        return instance;
    }

    public synchronized void add(){
        this.a = this.a + 1;
        System.out.println(a);
    }

    public static void main(String[] args){
        Singleton s1 = Singleton.getInstance();
        s1.add();

        Singleton s2 = Singleton.getInstance();
        s2.add();
    }
}