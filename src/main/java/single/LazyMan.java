package single;

import java.util.HashMap;
import java.util.Map;

//懒汉式单例  需要时加载 加载前会判断是否存在
/*1.私有化构造方法
2.私有全局变量
3.判断是否存在 */
public class LazyMan {

    private  LazyMan(){

    }
    private volatile static  LazyMan lazyMan;

    //单线程 可以
    //多线程 不行
    //双重检测锁模式的  懒汉式单例 DCL懒汉式
    public static  LazyMan getInstance(){
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    lazyMan = new LazyMan();

                    HashMap<Object, Object> HashMap = new HashMap<>();
                    /**
                     * 1、分配内存空间
                     * 2、执行构造方法，初始化对象
                     * 3、把这个对象指向这个空间
                     *
                     *  就有可能出现指令重排问题
                     *  比如执行的顺序是1 3 2 等
                     *  我们就可以添加volatile保证指令重排问题
                     */
                }
            }
        }

        return lazyMan;
    }
    public static void main(String[] args) {
        for (int i =1;i<=10;i++){
            new Thread(()->{
                lazyMan.getInstance();
            }).start();
        }
    }
}
