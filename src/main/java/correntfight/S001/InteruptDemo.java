package correntfight.S001;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Gxy on 2019/4/19.
 */
public class InteruptDemo {

    @Test
    public void test(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("thread run");
                    try {
                        Thread.sleep(5000);
                        System.out.println("Thread run end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        thread.start();
        try {
            Thread.currentThread().sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("-------------");

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
