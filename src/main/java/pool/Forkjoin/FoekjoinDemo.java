package pool.Forkjoin;

import java.util.concurrent.RecursiveTask;

/*
* 求和计算任务
*  如何使用Foekjoin
* 1.foekjoinPool 通过这个对象来执行
* 2.计算任务 foekjoinPool.execute（foekjoinTask task）
* 3.你的计算类必须要继承foekjoinTask
* */
public class FoekjoinDemo extends RecursiveTask<Long> {
    private long start ;
    private long end ;
    //临界值
    private  long temp;

    public FoekjoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    //计算方法
    @Override
    protected Long compute() {

        if((end-start)<temp){
            Long sum = 0L;
             for (long i=start;i<=end;i++){
                 sum+=1;
             }
            System.out.println(
                    sum
            );
            return sum;
        }else {//Foekjoin
           long middle =  (start+end)/2;//中间值
            //拆分任务
            FoekjoinDemo task1 = new FoekjoinDemo(start, middle);
            task1.fork();//把线程压入队列
            FoekjoinDemo task2 = new FoekjoinDemo(middle+1, end);
            task2.fork();//把线程压入队列
            //把分部结果汇总 得出总结果
            //long result =
            return  task1.join()+task2.join();

        }

    }
}
