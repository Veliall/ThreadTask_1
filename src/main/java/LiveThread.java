/**
 * Created by Igor Khristiuk
 * Date: 17.08.2021
 * Time: 15:23
 */

public class LiveThread extends Thread {

    private static final int SLEEP_TIME = 2500;

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(SLEEP_TIME);
                System.out.printf("%s говорит \"Я родился! И я живой!\"\n", Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            System.out.printf("%s был убит во сне. Очень зверски и беспощадно.\n", Thread.currentThread().getName());
        } finally {
            System.out.printf("%s уничтожен и забыт!\n", Thread.currentThread().getName());
        }
    }
}
