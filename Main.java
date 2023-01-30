
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

public class Main {

    public static void normalizeAnything() {
        System.out.println("Normalize a value that goes from -65 to 78");

        System.out.println(MH.normalize(-65, -65, 78));
        System.out.println(MH.normalize(-40, -65, 78));
        System.out.println(MH.normalize(0, -65, 78));
        System.out.println(MH.normalize(30, -65, 78));
        System.out.println(MH.normalize(78, -65, 78));
    }

    public static void mathExample() {
        //normalizeAnything(); 
    }

    public static void AESExample() {
        LogH.log(LogH.toPurple("--------------------- AES EXAMPLE ---------------------"));
        try {
            SecretKey key = obfAES.generateKey();
            String keyString = DatatypeConverter.printHexBinary(key.getEncoded());

            LogH.log("Secret key: " + keyString);

            String str = "I tawn to ÄÖ$$%Agwe212";
            LogH.log("String to Encrypt: " + str);

            String encrypted = obfAES.encryptAES(str, key);
            LogH.log("Encrypted String: " + encrypted);

            String decrypted = obfAES.decryptAES(encrypted, key);
            LogH.log("Decrypted String: " + decrypted);

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        LogH.log(LogH.toPurple("--------------------- AES EXAMPLE ---------------------"));
    }

    public static void RSAExample() {
        LogH.log(LogH.toPurple("--------------------- RSA EXAMPLE ---------------------"));

        try {

            KeyPair keyPair;
            keyPair = obfRSA.generateKeyPair();

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

//            String publicK = DatatypeConverter.printHexBinary(publicKey.getEncoded());
//            LogH.log("Public key: " + publicK);
//            
//            String privateK = DatatypeConverter.printHexBinary(privateKey.getEncoded());
//            LogH.log("Private key: " + privateK);
            String str = "I tawn to ÄÖ$$%Agwe212";
            LogH.log("String to Encrypt: " + str);

            String encrypted = obfRSA.encrypt(str, publicKey);
            LogH.log("Encrypted String with Public Key: " + encrypted);

            String decrypted = obfRSA.decrypt(encrypted, privateKey);
            LogH.log("Decrypted String with Private Key: " + decrypted);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        LogH.log(LogH.toPurple("--------------------- RSA EXAMPLE ---------------------"));
    }

    public static void base64Example() {
        LogH.log(LogH.toPurple("-------------------- Base64 EXAMPLE --------------------"));

        String str = "I tawn to ÄÖ$$%Agwe212";
        LogH.log("String to Encode: " + str);

        String encoded = ObfH.encodeBase64(str);
        LogH.log("Encoded String: " + encoded);

        String decoded = ObfH.decodeBase64(encoded);
        LogH.log("Decoded String: " + decoded);

        LogH.log(LogH.toPurple("-------------------- Base64 EXAMPLE --------------------"));
    }

    public static void xorExample() {
        LogH.log(LogH.toPurple("--------------------- XOR EXAMPLE ---------------------"));

        String str = "I tawn to ÄÖ$$%Agwe212";
        LogH.log("String to Encrypt: " + str);

        byte[] key = ObfH.generateKey(1);

        String encrypted = ObfH.encryptXOR(str, key);
        LogH.log("Encrypted String: " + encrypted);

        String decrypted = ObfH.decryptXOR(encrypted, key);
        LogH.log("Decrypted String: " + decrypted);

        LogH.log(LogH.toPurple("--------------------- XOR EXAMPLE ---------------------"));
    }

    public static void hashExample() {
        LogH.log(LogH.toPurple("-------------------- HASH EXAMPLE --------------------"));

        String str = "I tawn to ÄÖ$$%Agwe212";
        LogH.log("String to Hash: " + str);

        String hashSHA256 = ObfH.hashSHA256(str);
        LogH.log("Hash with SHA-256: " + hashSHA256);
        String hashMD5 = ObfH.hashMD5(str);
        LogH.log("Hash with MD5: " + hashMD5);

        LogH.log(LogH.toPurple("-------------------- HASH EXAMPLE --------------------"));
    }

    public static void obfExample() {
        AESExample();
        LogH.lineBreak();
        RSAExample();
        LogH.lineBreak();
        base64Example();
        LogH.lineBreak();
        xorExample();
        LogH.lineBreak();
        hashExample();
    }

    public static void colorExample() {
        {
            LogH.log(LogH.toPurple("------------------ HSV TO RGB EXAMPLE ------------------"));

            float hue = 0.294f, sat = 0.557f, val = 0.9568f;

            LogH.log("Hue: " + LogH.toBlue(String.valueOf(hue)) + " Sat: " + LogH.toBlue(String.valueOf(sat)) + " Val: " + LogH.toBlue(String.valueOf(val)));

            RGB col = ColH.HSVtoRGB(hue, sat, val);

            LogH.log("Red: " + LogH.toBlue(String.valueOf(col.r)) + " Green: " + LogH.toBlue(String.valueOf(col.g)) + " Blue: " + LogH.toBlue(String.valueOf(col.b)));

            LogH.log(LogH.toPurple("------------------ HSV TO RGB EXAMPLE ------------------"));
        }
        LogH.lineBreak();

        {
            LogH.log(LogH.toPurple("------------------ RGB TO HSV EXAMPLE ------------------"));

            int r = 100, g = 244, b = 204;

            LogH.log("Red: " + LogH.toBlue(String.valueOf(r)) + " Green: " + LogH.toBlue(String.valueOf(g)) + " Blue: " + LogH.toBlue(String.valueOf(b)));

            HSV col = ColH.RGBtoHSV(r, g, b);

            LogH.log("Hue: " + LogH.toBlue(String.valueOf(col.h)) + " Sat: " + LogH.toBlue(String.valueOf(col.s)) + " Val: " + LogH.toBlue(String.valueOf(col.v)));

            LogH.log(LogH.toPurple("------------------ RGB TO HSV EXAMPLE ------------------"));
        }
        
        {
            LogH.log(LogH.toPurple("------------------ RGB TO HSL EXAMPLE ------------------"));

            int r = 250, g = 10, b = 204;

            LogH.log("Red: " + LogH.toBlue(String.valueOf(r)) + " Green: " + LogH.toBlue(String.valueOf(g)) + " Blue: " + LogH.toBlue(String.valueOf(b)));

            HSL col = ColH.RGBtoHSL(r, g, b);

            LogH.log("Hue: " + LogH.toBlue(String.valueOf(col.h)) + " Sat: " + LogH.toBlue(String.valueOf(col.s)) + " Light: " + LogH.toBlue(String.valueOf(col.l)));

            LogH.log(LogH.toPurple("------------------ RGB TO HSL EXAMPLE ------------------"));
        }
    }

    public static void main(String[] args) {
//        mathExample();
//        obfExample();
        colorExample();
    }
}
