package theDiningPhilosophers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * <p>
 * Description: 哲学家就餐
 * <p>
 * 5个哲学家，0-4 顺时针编号 <br>
 * 5把叉子， 0-4 顺时针编号  <br>
 * 必须同时拿到左右两边的叉子才能吃到面
 * </p>
 * <p>
 * Created on 2021/5/6.
 *
 * @author pangwen
 * @version 0.1
 */
public class DiningPhilosophers {

    /**
     * 最多满足2个人同时吃饭
     */
    Semaphore eatLimit = new Semaphore(2);

    /**
     * 5把叉子, 必须同时拿到左右2把叉子才能吃到面
     */
    Semaphore[] forkSemaphores = {
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1)
    };

    /**
     * 哲学家进餐
     *
     * @param philosopher   哲学家编号
     * @param pickLeftFork  拿起左边叉子
     * @param pickRightFork 拿起右边查找
     * @param eat           吃饭
     * @param putLeftFork   放回左边叉子
     * @param putRightFork  放回右边叉子
     * @throws InterruptedException 线程中断异常
     */
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        //左边叉子编号
        int leftFork = philosopher;
        //右边叉子编号
        int rightFork = (philosopher + 1) % 5;

        //有人就餐时，就餐限制 -1
        eatLimit.acquire();

        forkSemaphores[leftFork].acquire();
        forkSemaphores[rightFork].acquire();


        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        //拿到叉子后即可释放吃饭限制资源
        eatLimit.release();

        putLeftFork.run();
        forkSemaphores[leftFork].release();

        putRightFork.run();
        forkSemaphores[rightFork].release();

    }

}
