package up.server;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SicretInfo {

    private String algorithm = "AES";
    private String transformation = "AES/GCM/NoPadding";

    public byte[] encryptMessage(String message){
        try {
            Cipher cipher = Cipher.getInstance(transformation);
            SecretKey sKey = new SecretKeySpec("qwerty1234567890".getBytes(), algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            return cipher.doFinal(message.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decryptMessage(byte[] encMessage){
        try{
            Cipher cipher = Cipher.getInstance(transformation);
            SecretKey sKey = new SecretKeySpec("qwerty1234567890".getBytes(), algorithm);
            cipher.init(Cipher.DECRYPT_MODE, sKey);
            byte[] message = cipher.doFinal(encMessage);
            return new String(message);
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
