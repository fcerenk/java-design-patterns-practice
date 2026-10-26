package singleton;

public class ThreadTest {
    public static void main(String[]args){
        for(int i =0; i<10; i++){
            new Thread(()->{
                System.out.println(Logger.getInstance().hashCode());
            }).start();
        }
    }
}
