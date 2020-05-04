package com.springboot.utils.encryptiontool;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

public class DesEncryption {
    // 定义加密算法DESede(即3DES)
    private static final String Algorithm = "DESede";
    //秘钥
    private static final String PASSWORD_CRYPT_KEY = "PASSWORD_KEY";

    public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException {
        byte[] key = new byte[24]; // 声明一个24位的字节数组，默认里面都是0
        byte[] temp = keyStr.getBytes("UTF-8"); // 将字符串转成字节数组
        if (key.length > temp.length) {
            // 如果temp不够24位，则拷贝temp数组整个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, temp.length);
        } else {
            // 如果temp大于24位，则拷贝temp数组24个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, key.length);
        }
        return key;
    }

    public static byte[] encryptMode(byte[] originalText) {
        try {
            SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), Algorithm); // 生成密钥
            Cipher cipher = Cipher.getInstance(Algorithm); // 实例化负责加密/解密的Cipher工具类
            cipher.init(Cipher.ENCRYPT_MODE, deskey); // 初始化为加密模式
            return cipher.doFinal(originalText);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public static byte[] decryptMode(byte[] cipherText) {
        try {
            SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);
            Cipher cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.DECRYPT_MODE, deskey); // 初始化为解密模式
            return cipher.doFinal(cipherText);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public static String byte2Hex(byte[] b){
        StringBuilder hs= new StringBuilder();
        String stmp="";
        for (byte value : b) {
            stmp = (Integer.toHexString(value & 0XFF));
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString().toUpperCase();

    }

    public static void main(String[] args) {
        String msg = "1213456789";
        System.out.println("【加密前】：" + msg);

        // 加密
        byte[] secretArr = DesEncryption.encryptMode(msg.getBytes());
        String str = byte2Hex(secretArr);
        System.out.println("【加密后】：" + str);

        // 解密
        byte[] myMsgArr = DesEncryption.decryptMode(secretArr);
        System.out.println("【解密后】：" + new String(myMsgArr));
    }
}
