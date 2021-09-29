import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Vtest {
 /*   //不加 volatile 程序就会死循环
    private volatile static  int num = 0;
    public static void main(String[] args) throws InterruptedException {
        //main
        new Thread(()->{
            while (num==0){

            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        num = 1;
        System.out.println(num);
    }*/


    private static volatile AtomicInteger number = new AtomicInteger();

    public static void add(){
//        number++;
        number.incrementAndGet();  //底层是CAS保证的原子性
    }

    public static void main(String[] args) {
        //理论上number  === 20000

        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000 ; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount()>2){
            //main  gc
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+",num="+number);
    }


}
