package cn.medemede.t2;

/**
 * @author Saber
 */
public class Business {
    /**这里相当于定义了控制该谁执行的一个信号灯*/
    private boolean bShouldSub = true;

    synchronized void mainThread(int i)
    {
        if(bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int j=0;j<100;j++)
        {
            System.out.println(Thread.currentThread().getName() + ":i=" + i +",j=" + j);
        }
        bShouldSub = true;
        this.notify();

    }

    synchronized void subThread(int i)
    {
        if(!bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int j=0;j<10;j++)
        {
            System.out.println(Thread.currentThread().getName() + ":i=" + i +",j=" + j);
        }
        bShouldSub = false;
        this.notify();
    }
}
