import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Igor Khristiuk
 * Date: 17.08.2021
 * Time: 15:35
 */

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int COUNT_OF_THREADS = 4;

        final ExecutorService threadPool = Executors.newFixedThreadPool(4);

        final List<Callable<Integer>> callableList = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_THREADS; i++) {
            callableList.add(new LiveThread());
        }

        final List<Future<Integer>> task = threadPool.invokeAll(callableList);
        for (int i = 0; i < task.size(); i++) {
            Future<Integer> res = task.get(i);
            System.out.println("Поток " + (i + 1) + " напечатал " + res.get() + " сообщения");
        }

        final int result = threadPool.invokeAny(callableList);
        System.out.println("Самая быстрая задача напечатала " + result + " сообщений");
        threadPool.shutdown();

    }
}
