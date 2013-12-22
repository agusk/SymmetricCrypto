## SymmetricCrypto

Sample of Symmetric Cryptography in Java.


## Usage

Firstly you generate key and store it in a file. To read a key file, you can call readKeyFile(). Encryption and decryption can be done by calling encryp() and decrypt() methods.

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
