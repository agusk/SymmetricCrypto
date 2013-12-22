package com.agusk;

/**
 * Created with IntelliJ IDEA.
 * User: Agus
 * Date: 12/22/13
 * Time: 6:16 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class SymmetricCrypto {
    public void generateKey(String keyFile) {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            keyGen.init(56);
            Key key = keyGen.generateKey();

            FileOutputStream f = new FileOutputStream(keyFile);
            f.write(key.getEncoded());
            f.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public byte[] readKeyFile(String keyFile) {
        byte[] fileContent = null;

        try {
            FileInputStream fin = new FileInputStream(keyFile);
            int len = fin.available();
            fileContent = new byte[len];
            fin.read(fileContent,0,len);
            fin.close();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return fileContent;

    }

    public byte[] encrypt(String message, byte[] keyEncoded) {
        byte[] encypted = null;
        try {
            byte[] input = message.getBytes("UTF8");

            SecretKeySpec key = new SecretKeySpec(keyEncoded, "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, key);
            encypted = cipher.doFinal(input);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return encypted;
    }

    public byte[] decrypt(byte[] encypted, byte[] keyEncoded) {
        byte[] plainText = null;
        try {

            SecretKeySpec key = new SecretKeySpec(keyEncoded, "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, key);
            plainText = cipher.doFinal(encypted);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return plainText;
    }
}
