package test;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月08日 17:58
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(Base64.getDecoder().decode("a03fc1179e0a4792c795e18da21ffc28"));
    }
}
