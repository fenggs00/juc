public class Test
{
    public static  void  main(String[] args){
        System.out.println(
                Runtime.getRuntime().availableProcessors()
        );

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
