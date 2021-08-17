/**
 * Created by Igor Khristiuk
 * Date: 17.08.2021
 * Time: 15:35
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ThreadGroup mainGroup = new ThreadGroup("mainGroup");
        LiveThread liveThread = new LiveThread();

        final Thread thread1 = new Thread(mainGroup, liveThread, "Лунтик");
        final Thread thread2 = new Thread(mainGroup, liveThread, "Швунтик");
        final Thread thread3 = new Thread(mainGroup, liveThread, "Нунтик");
        final Thread thread4 = new Thread(mainGroup, liveThread, "Фунтик");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(15000);
        mainGroup.interrupt();

    }
}
