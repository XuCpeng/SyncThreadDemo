package cn.medemede.t1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * @author Saber
 */
public class MyThreadFactory implements ThreadFactory {

    /**
     * 计数器
     */
    private int counter;
    /**
     * 线程名
     */
    private String name;
    /**
     * 状态
     */
    private List<String> stats;

    MyThreadFactory(String name) {
        counter=0;
        this.name=name;
        stats=new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread=new Thread(r,name+"Thread"+counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s \n", thread.getId(), thread.getName(), new Date()));
        return thread;
    }

    public String getStats(){
        StringBuilder buffer = new StringBuilder();
        for (String stat : stats) {
            buffer.append(stat);
        }
        return buffer.toString();
    }
}
