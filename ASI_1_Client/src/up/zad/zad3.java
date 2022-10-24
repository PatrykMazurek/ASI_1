package up.zad;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class zad3 implements Runnable{

    private static List<File> listFile;
    private boolean show;
    private Path location;

    public zad3(Path location, boolean show){
        if (listFile == null){
            listFile = new ArrayList<>();
        }
        this.show = show;
        this.location = location;
    }

    @Override
    public void run() {
            if (this.show){
                showChanged();
            }else{
                getListFiles(this.location);
            }
    }

    public void getListFiles(Path location){
        File[] f = location.toFile().listFiles();
        listFile = Arrays.stream(f).collect(Collectors.toList());
    }

    public void showChanged(){

    }
}
