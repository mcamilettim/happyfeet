package cl.camiletti.happyFeetWeb.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.core.env.Environment;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

public class StringEncrypt {
	public StringEncrypt(Environment env) {
		this.env = env;
	}
	private Environment env;
 
	private String alg = "AES";
    private String cI = "AES/CBC/PKCS5Padding";
 
    public String encrypt(String cleartext) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(env.getProperty("encrypt.key").getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(env.getProperty("encrypt.iv").getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(cleartext.getBytes());
            return new String(encodeBase64(encrypted));
    }
 
    public String decrypt(String encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(env.getProperty("encrypt.key").getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(env.getProperty("encrypt.iv").getBytes());
            byte[] enc = decodeBase64(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
    }
    
 
}
