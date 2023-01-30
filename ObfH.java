
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



// symetric
class obfAES {

    public static String encryptAES(String plaintext, SecretKey key) throws Exception {
        byte[] plaintextBytes = plaintext.getBytes();
        byte[] ciphertextBytes = encryptAES_(plaintextBytes, key);
        return ObfH.encodeBase64(ciphertextBytes);
    }

    public static String decryptAES(String ciphertext, SecretKey key) throws Exception {
        byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);
        byte[] plaintextBytes = decryptAES_(ciphertextBytes, key);
        return new String(plaintextBytes);
    }

    private static byte[] encryptAES_(byte[] plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(plaintext);
    }

    private static byte[] decryptAES_(byte[] ciphertext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(ciphertext);
    }

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }

    public static SecretKey getKey(byte[] keyBytes) {
        return new SecretKeySpec(keyBytes, "AES");
    }
}

// asymetric
class obfRSA {

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512); // 2048
        return keyPairGenerator.generateKeyPair();
    }
    
    public static String encrypt(String plaintext, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] ciphertextBytes = cipher.doFinal(plaintext.getBytes());
        return ObfH.encodeBase64(ciphertextBytes);
    }

    public static String decrypt(String ciphertext, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);
        byte[] plaintextBytes = cipher.doFinal(ciphertextBytes);
        return new String(plaintextBytes);
    }

    public static byte[] encrypt_(byte[] plaintext, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plaintext);
    }

    public static byte[] decrypt_(byte[] ciphertext, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(ciphertext);
    }

    public static PublicKey getPublicKey(byte[] keyBytes) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    public static PrivateKey getPrivateKey(byte[] keyBytes) throws Exception {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}

public class ObfH {

// Planned AES, base64, xor, hash md5, files maybe?
    public static String encodeBase64(byte[] strByte) {
        byte[] encodedBytes = Base64.getEncoder().encode(strByte);
        return new String(encodedBytes);
    }

    public static String decodeBase64(byte[] strByte) {
        byte[] decodedBytes = Base64.getDecoder().decode(strByte);
        return new String(decodedBytes);
    }

    public static String encodeBase64(String str) {
        byte[] encodedBytes = Base64.getEncoder().encode(str.getBytes());
        return new String(encodedBytes);
    }

    public static String decodeBase64(String str) {
        byte[] decodedBytes = Base64.getDecoder().decode(str.getBytes());
        return new String(decodedBytes);
    }

    public static String encryptXOR(String plaintext, byte[] key) {
        byte[] plainBytes = plaintext.getBytes();
        byte[] cipherBytes = new byte[plainBytes.length];

        for (int i = 0; i < plainBytes.length; i++) {
            cipherBytes[i] = (byte) (plainBytes[i] ^ key[i % key.length]);
        }

        return encodeBase64(cipherBytes);
    }

    public static String decryptXOR(String ciphertext, byte[] key) {
        byte[] cipherBytes = Base64.getDecoder().decode(ciphertext);
        byte[] plainBytes = new byte[cipherBytes.length];

        for (int i = 0; i < cipherBytes.length; i++) {
            plainBytes[i] = (byte) (cipherBytes[i] ^ key[i % key.length]);
        }

        return new String(plainBytes);
    }

    public static byte[] generateKey(int keySize) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[keySize];
        secureRandom.nextBytes(key);
        return key;
    }

    public static String hashSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String hashMD5(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
