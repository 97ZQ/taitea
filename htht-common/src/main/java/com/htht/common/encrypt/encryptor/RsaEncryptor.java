package com.htht.common.encrypt.encryptor;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.htht.common.encrypt.EncryptContext;
import com.htht.common.enums.AlgorithmType;
import com.htht.common.enums.EncodeType;
import com.htht.common.utils.EncryptUtils;
import com.htht.common.utils.StringUtils;


/**
 * RSA算法实现
 *
 * @author 老马
 * @version 4.6.0
 */
public class RsaEncryptor extends AbstractEncryptor {

    private final EncryptContext context;

    public RsaEncryptor(EncryptContext context) {
        super(context);
        String privateKey = context.getPrivateKey();
        String publicKey = context.getPublicKey();
        if (StringUtils.isAnyEmpty(privateKey, publicKey)) {
            throw new IllegalArgumentException("RSA公私钥均需要提供，公钥加密，私钥解密。");
        }
        this.context = context;
    }

    /**
     * 获得当前算法
     */
    @Override
    public AlgorithmType algorithm() {
        return AlgorithmType.RSA;
    }

    /**
     * 加密
     *
     * @param value      待加密字符串
     * @param encodeType 加密后的编码格式
     */
    @Override
    public String encrypt(String value, EncodeType encodeType) {
        if (encodeType == EncodeType.HEX) {
            return EncryptUtils.encryptByRsaHex(value, context.getPublicKey());
        } else {
            return EncryptUtils.encryptByRsa(value, context.getPublicKey());
        }
    }

    /**
     * 解密
     *
     * @param value      待加密字符串
     */
    @Override
    public String decrypt(String value) {
        return EncryptUtils.decryptByRsa(value, context.getPrivateKey());
    }
}