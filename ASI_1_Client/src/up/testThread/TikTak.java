package up.testThread;

public class TikTak {

    public synchronized void tik(boolean work){
        if(!work){
            notify();
            return;
        }
        System.out.println("Wyświetlam Tik");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void tak(boolean work){
        if(!work){
            notify();
            return;
        }
        System.out.println("Wyświetlam Tak");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void zak(boolean work){
        if(!work){
            notify();
            return;
        }
        System.out.println("Wyświetlam Zak");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
