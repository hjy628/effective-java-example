package chap10;


import java.util.concurrent.TimeUnit;

//Properly synchronized cooperative thread termination
public class StopThreadVolatileGood {
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException{
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested){
                    i++;
                }
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
