package com.htht.business.thirty.camera.video;

//import com.inspur.evp.common.utils.DateUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 签名助手
 */
public class SignatureHelper {
    private static final Logger log = LoggerFactory.getLogger(SignatureHelper.class);
    private static final String HASH_ALGORITHM = "HmacSHA256";

    /**
     * @return
     */
    public static synchronized String nonce() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    /**
     * 请求参数排序并生成加密字符串
     *
     * @param apiKey
     * @param timestamp
     * @param nonce
     * @return
     */
    public static String generateJoinStr(String apiKey, String timestamp, String
            nonce, Map<String, Object> requestParamsMap) {
        List<String> beforeSort = new ArrayList<String>();
        beforeSort.add(apiKey);
        beforeSort.add(timestamp);
        beforeSort.add(nonce);
        if (requestParamsMap != null && requestParamsMap.size() > 0) {
            Iterator<Map.Entry<String, Object>> it = requestParamsMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = it.next();
                beforeSort.add(entry.getValue() + "");
            }
        }
        // 排序
        beforeSort.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                try {
                    String s1 = new String(o1.toString().getBytes("GB2312"), "ISO_8859_1");
                    String s2 = new String(o2.toString().getBytes("GB2312"), "ISO_8859_1");
                    return s1.compareTo(s2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
        StringBuilder afterSort = new StringBuilder();
        for (int i = 0; i < beforeSort.size(); i++) {
            afterSort.append(beforeSort.get(i));
            if (i < beforeSort.size() - 1) {
                afterSort.append("&");
            }
        }
        return afterSort.toString();
    }

    /**
     * @param appendStr
     * @param appSecret
     * @return
     */
    private static String genEncryptString(String appendStr, String appSecret) throws
            NoSuchAlgorithmException, InvalidKeyException {
        Key secretKey = new SecretKeySpec(appSecret.getBytes(), HASH_ALGORITHM);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        //完成hamc‐sha256签名
        final byte[] hmac = mac.doFinal(appendStr.getBytes());
        StringBuilder sb = new StringBuilder(hmac.length * 2);
        Formatter formatter = new Formatter(sb);
        for (byte b : hmac) {
            formatter.format("%02x", b);
        }
        //完成16进制编码
        return sb.toString();
    }

    /**
     * @param apiKey
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    public static String sign(String apiKey, String timestamp, String nonce, String signature) {
        return String.format("appkey=%s,timestamp=%s,nonceStr=%s,sign=%s", apiKey, timestamp,
                nonce, signature);
    }

    /**
     * @param apiKey
     * @param appSecret
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    public static String token(String apiKey, String appSecret, String timestamp, String
            nonce, Map<String, Object> requestParams) throws InvalidKeyException, NoSuchAlgorithmException {
        String appendStr = generateJoinStr(apiKey, timestamp, nonce, requestParams);
        //System.out.println("appendStr："+ appendStr);
        String signature = genEncryptString(appendStr, appSecret);
        //System.out.println("signature："+ signature);
        String sign = sign(apiKey, timestamp, nonce, signature);
        return DigestUtils.md5Hex(sign);
    }

    /**
     * @param appKey
     * @param timestamp
     * @param nonce
     * @param token
     * @return
     */
    public static boolean matchSign(String appKey, String appSecret, String timestamp, String
            nonce, String token) {
        try {
            String t = token(appKey, timestamp, nonce, appSecret, null);
            return token.equals(t);
        } catch (InvalidKeyException e) {
            log.error("InvalidKeyException", e);
        } catch (NoSuchAlgorithmException e) {
            log.error("NoSuchAlgorithmException", e);
        }
        return false;
    }

    /**
     * @param apiKey
     * @return
     */
    public static String genauthorization(String apiKey, String appSecret) throws
            InvalidKeyException, NoSuchAlgorithmException {
        String nonce = nonce();
        String timestamp = Long.toString(System.currentTimeMillis());
        String appendStr = generateJoinStr(apiKey,timestamp, nonce, null);
        String signature = genEncryptString(appendStr, appSecret);
        //return signature;
        return "appkey=" + apiKey + ",timestamp=" + timestamp + ",nonce=" + nonce + ",sign=" +
                signature;
    }
    /**
     * @param apiKey
     * @return
     */
    public static String genauthorization2(String apiKey, String appSecret,String timestamp,String nonce) throws
            InvalidKeyException, NoSuchAlgorithmException {
        //String nonce = nonce();
        //String timestamp = Long.toString(System.currentTimeMillis());
        String appendStr = generateJoinStr(apiKey,timestamp, nonce, null);
        String signature = genEncryptString(appendStr, appSecret);
        return signature;
        /*return "appkey=" + apiKey + ",timestamp=" + timestamp + ",nonce=" + nonce + ",sign=" +
                signature;*/
    }
}
