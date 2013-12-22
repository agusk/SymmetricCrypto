package com.agusk;

/**
 * Created with IntelliJ IDEA.
 * User: Agus
 * Date: 12/22/13
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */

public class TestCrypto {

    public static void main(String[] args) throws Exception {

        SymmetricCrypto crypto = new SymmetricCrypto();
        crypto.generateKey("d:/temp/crypto.key");
        String message = "Welcome to Java";

        byte[] key = crypto.readKeyFile("d:/temp/crypto.key");
        byte[] encrypted = crypto.encrypt(message, key);
        byte[] plaintext = crypto.decrypt(encrypted, key);

        System.out.println("message: " + message);
        System.out.println("encrypted: " + new String(encrypted));
        System.out.println("encrypted Hex: " + StringUtils.getHexString(encrypted));
        System.out.println("plaintext: " + new String(plaintext));


    }
}
