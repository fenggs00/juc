package single;


//饿汉式单例    --浪费资源 类加载的时候就加载了
//1.单例模式私有化构造器
//2.用静态常量 装对象
//3.静态方法获取对象
public class Hungry {

    private Hungry(){

    }
    private  final  static  Hungry HUNGRY = new Hungry();

    public  static  Hungry  getInstance(){
        return HUNGRY;
    }
}
