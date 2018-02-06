package cn.medemede.t2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Saber
 */
public class ThreadTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ThreadTest().init();

    }

    private void init()
    {
        final Business business = new Business();
        MyThreadFactory myThreadFactory=new MyThreadFactory("子线程");
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                4,
                10,
                200,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5),
                myThreadFactory);

        /*
          用线程池创建了一个子线程，来运行subThread方法，子线程的方法运行一次后把自己wait
          此时，mainThread的循环启动
          mainThread运行完一次后把自己wait
          subThread得bShouldSub锁，继续执行
          ...
         */
        threadPoolExecutor.execute(() -> {
            for(int i=0;i<50;i++)
            {
                business.subThread(i);
            }
        }
        );

        for(int i=0;i<50;i++)
        {
            business.mainThread(i);
        }
    }
}
