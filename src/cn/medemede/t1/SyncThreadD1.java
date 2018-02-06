package cn.medemede.t1;

/**
 * @author Saber
 */
public class SyncThreadD1 implements Runnable {
    private static int count;
    SyncThreadD1(){
        count=0;
    }
    @Override
    public void run() {
        for (int i = 0; i <3; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + (count++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
