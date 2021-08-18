/**
 * Created by Igor Khristiuk
 * Date: 17.08.2021
 * Time: 15:35
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ThreadGroup mainGroup = new ThreadGroup("mainGroup");
        LiveThread liveThread = new LiveThread();

        Thread[] threads = new Thread[]{
                new Thread(mainGroup, liveThread, "Лунтик"),
                new Thread(mainGroup, liveThread, "Швунтик"),
                new Thread(mainGroup, liveThread, "Нунтик"),
                new Thread(mainGroup, liveThread, "Фунтик")
        };

        for (Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(15000);
        mainGroup.interrupt();
    }
}
