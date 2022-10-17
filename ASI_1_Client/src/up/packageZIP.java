package up;

import java.io.*;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class packageZIP {

    public void createArchive(File[] files, String zipName){
        if(files.length > 0){
            try {
                ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream(zipName));
                zOut.setMethod(ZipOutputStream.DEFLATED);
                zOut.setLevel(9);
                for (File f : files){
                    ZipEntry zipE = new ZipEntry(f.getName());
                    zOut.putNextEntry(zipE);
                    FileInputStream fIn = new FileInputStream(f);
//                    zOut.write(fIn.readAllBytes());
                    // alternatywna wersja dla jav-y w wersji 1.8
                    byte[] buff = new byte[2048];
                    int length;
                    while((length = fIn.read(buff)) >= 0){
                        zOut.write(buff,0,length);
                    }

                    fIn.close();
                    zOut.closeEntry();
                }
                zOut.flush();
                zOut.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Brak plików do spakowania");
        }
    }

    public void unpackageArchive(Path dLocation, String zipName){
        try {
            ZipInputStream zIn = new ZipInputStream(new FileInputStream(zipName));
            ZipEntry zipE;
            while (( zipE = zIn.getNextEntry()) != null){
                FileOutputStream fOut = new FileOutputStream(
                        new File( dLocation.toString(), zipE.getName())
                );
//                fOut.write(zIn.readAllBytes());
                // alternatywne rozwiązanie dla jav-y w wrsji 1.8
                byte[] buff = new byte[2048];
                int length;
                while ((length = zIn.read(buff)) >= 0){
                    fOut.write(buff, 0, length);
                }
                fOut.flush();
                fOut.close();
                zIn.closeEntry();
            }
            zIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
