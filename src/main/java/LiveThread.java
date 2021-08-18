import java.util.concurrent.Callable;

/**
 * Created by Igor Khristiuk
 * Date: 17.08.2021
 * Time: 15:23
 */

public class LiveThread extends Thread implements Callable<Integer> {

    private static final int SLEEP_TIME = 2500;
    private int count = 0;

    @Override
    public Integer call() {
        try {
            for (int i = 0; i < Math.random() * 5; i++) {
                Thread.sleep(SLEEP_TIME);
                System.out.printf("%s говорит \"Я родился! И я живой!\"\n", Thread.currentThread().getName());
                count++;
            }
        } catch (InterruptedException e) {
            System.out.printf("%s был убит во сне. Очень зверски и беспощадно.\n", Thread.currentThread().getName());
            count++;
        } finally {
            System.out.printf("%s уничтожен и забыт!\n", Thread.currentThread().getName());
            count++;
        }
        return count;
    }
}
