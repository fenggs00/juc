import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class sbq {
    public static  void  main(String[] args){
        SynchronousQueue<Object> objects = new SynchronousQueue<>();

        new  Thread(()->{
            System.out.println(Thread.currentThread().getName()+"put1");
            try {
                System.out.println(Thread.currentThread().getName()+"put1");
                objects.put("1");
                System.out.println(Thread.currentThread().getName()+"put2");
                objects.put("2");
                System.out.println(Thread.currentThread().getName()+"put3");
                objects.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new  Thread(()->{
            System.out.println(Thread.currentThread().getName()+"put1");
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"=>" + objects.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"=>" + objects.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"=>" + objects.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }

    public static void  t1(){

    }

}
