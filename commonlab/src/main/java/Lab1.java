/**
 * Created by gavin on 2020/3/14.
 */
public class Lab1 {

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 1000; i++){
            Thread.sleep(500);
            System.out.print(String.format("\r%04d", i));
        }
    }
}
