package com.example.aes;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public class AesSample {

    public static String encryptTextAesWithCbc(String secret, String salt, String plainText) {
        TextEncryptor encryptor = Encryptors.text(secret, salt);
        return encryptor.encrypt(plainText);
    }

    public static String decryptTextByAesWithCbc(String secret, String salt, String cipherText) {
        TextEncryptor decryptor = Encryptors.text(secret, salt);
        return decryptor.decrypt(cipherText);
    }

    public static String encryptTextByAesWithGcm(String secret, String salt, String plainText) {
        TextEncryptor encryptor = Encryptors.delux(secret, salt);
        return encryptor.encrypt(plainText);
    }

    public static String decryptTextByAesWithGcm(String secret, String salt, String plainText) {
        TextEncryptor decryptor = Encryptors.delux(secret, salt);
        return decryptor.decrypt(plainText);
    }

    // バイト文字列の暗号化ももちろん可能
}
