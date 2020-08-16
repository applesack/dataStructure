package thread;

import myImpl.sortAlgorithm.MyQuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月15日 23:58
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Callable<Integer>> callableList_1 = new ArrayList<>();
        List<Callable<Integer>> callableList_2 = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i<4; i++) {
            callableList_1.add(new MyCallable(i, random.nextBoolean()));
        }
        for (int i = 1; i<5; i++) {
            callableList_2.add(new MyCallable(20+i));
        }
        InvokeTaskForce(callableList_1, "所有任务执行成功");
        InvokeTaskForce(callableList_2, "所有任务执行成功");
    }

    private static final ExecutorService pool = Executors.newFixedThreadPool(3);
    private static void InvokeTaskForce(List<Callable<Integer>> runnableList, String msg)
            throws InterruptedException, ExecutionException {
        List<Future<Integer>> futures = pool.invokeAll(runnableList, 4, TimeUnit.SECONDS);

        for (Future future : futures) {
            future.get();
        }

        System.out.println(msg);
    }

    private static class MyCallable implements Callable<Integer> {

        private int id;
        private boolean flag;
        public MyCallable(Integer id) {
            this.id = id;
        }
        public MyCallable(Integer id, boolean flag) {
            this(id);
            this.flag = flag;
        }

        @Override
        public Integer call() throws Exception {
            if (this.flag)
                Thread.sleep(1500);
            if (id == 0)
                Thread.sleep(6000);
            System.out.println(id);
            return null;
        }
    }
}
