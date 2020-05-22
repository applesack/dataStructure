package test;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月08日 17:58
 */
public class Test {

    public static void main(String[] args) {
        String str = "1:2:3:4";
        System.out.println(Arrays.toString(str.split("\\:")));
    }
}
