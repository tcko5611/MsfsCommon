/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author DELL
 */
public class Decryptor {

    public static String encrypt(String value) {
        try {
            String key = "Bar12345Bar12345"; // 128 bit key
            String initVector = "RandomInitVector";
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            //System.out.println("encrypted string: "
            //        + Base64.encodeBase64String(encrypted));

            return Base64.encodeBase64String(encrypted);
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String encrypted) {
        try {
            String key = "Bar12345Bar12345"; // 128 bit key
            String initVector = "RandomInitVector";
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        // String key = "Bar12345Bar12345"; // 128 bit key
        // String initVector = "RandomInitVector"; // 16 bytes IV
        //String encrypt = encrypt("64-27-37-39-1B-51,5");
        //System.out.println(encrypt);
        String encrypt = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader("D:/temp/license.txt"));
            encrypt = in.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Decryptor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Decryptor.class.getName()).log(Level.SEVERE, null, ex);
        }

        String decrypt = decrypt(encrypt);
        System.out.println(decrypt);
        // System.out.println(decrypt(key,
        //         encrypt(key, "64-27-37-39-1B-51,5")));
    }
}
