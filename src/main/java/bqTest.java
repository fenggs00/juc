import java.util.concurrent.ArrayBlockingQueue;

public class bqTest
{

    public static  void  main(String[] args){
        t1();
    }

    public static void  t1(){

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));
        //抛出异常：java.lang.IllegalStateException: Queue full
       //System.out.println(arrayBlockingQueue.add("d"));
        System.out.println("--------------------");
        System.out.println(arrayBlockingQueue.element());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());


    }
}
