package com.example.aes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AesSampleTest {

    @Test
    void testEncryptAndDecryptByAesWithCbc() {
        String secret = "secret";
        String salt = "0123456789abcdef";
        String plainText = "plaint_text";

        String encrypted = AesSample.encryptTextAesWithCbc(secret, salt, plainText);
        assertNotEquals(plainText, encrypted);
        String decrypted = AesSample.decryptTextByAesWithCbc(secret, salt, encrypted);
        assertEquals(plainText, decrypted);
    }

    @Test
    void testEncryptAndDecryptByAesWithGcm() {
        String secret = "secret";
        String salt = "0123456789abcdef";
        String plainText = "plaint_text";

        String encrypted = AesSample.encryptTextByAesWithGcm(secret, salt, plainText);
        assertNotEquals(plainText, encrypted);
        String decrypted = AesSample.decryptTextByAesWithGcm(secret, salt, encrypted);
        assertEquals(plainText, decrypted);
    }

}