package cn.medemede.t1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Saber
 */
public class Main {
    public static void main(String[] args) {
        SyncThreadD1 d1=new SyncThreadD1();
        MyThreadFactory myThreadFactory=new MyThreadFactory("d1");
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor
                (4,
                10,
                200,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5),
                myThreadFactory);

        threadPoolExecutor.execute(d1);
        threadPoolExecutor.execute(d1);
        threadPoolExecutor.execute(d1);
        threadPoolExecutor.execute(d1);
        System.out.println(myThreadFactory.getStats());

    }


}
