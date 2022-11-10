package up.testThread;

public class StartTikTak implements Runnable{

    Thread th;
    TikTak tObj;

    public StartTikTak(String name, TikTak tt){
        th = new Thread(this, name);
        tObj = tt;
        th.start();
    }

    @Override
    public void run() {
        if (th.getName().compareTo("Tik") == 0){
            for (int i = 0; i < 7; i++){
                tObj.tik(true);
            }
            tObj.tik(false);
        }else if (th.getName().compareTo("Zak") == 0){
            for (int i = 0; i < 7; i++){
                tObj.zak(true);
            }
            tObj.zak(false);
        }else{
            for (int i = 0; i < 7; i++){
                tObj.tak(true);
            }
            tObj.tak(false);
        }
    }
}
