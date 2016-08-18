package com.webcc.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhong on 16-8-16.
 */
public class EncodeUtils {

    public static String MD5(String text, String charset) {
        MessageDigest msgDigest = null;
        try {
            msgDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(
                    "System doesn't support MD5 algorithm.");
        }
        try {
            msgDigest.update(text.getBytes(charset));    //注意改接口是按照指定编码形式签名
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(
                    "System doesn't support your  EncodingException.");
        }
        byte[] bytes = msgDigest.digest();
        return encodeHex(bytes);
    }

    public static String encodeHex(byte[] data){
        StringBuilder builder = new StringBuilder();
        for(byte cipher : data) {
            String toHexStr = Integer.toHexString(cipher & 0xff);
            builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);
        }
        return builder.toString();
    }

}
