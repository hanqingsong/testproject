package md5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	public static String crypt(String str){
		try {
			return crypt(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * Encodes a string
	 *
	 * @param str String to encode
	 * @return Encoded String
	 * @throws UnsupportedEncodingException 
	 *
	 */
	public static String crypt(String str, String charsetName) throws UnsupportedEncodingException {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}

		StringBuffer hexString = new StringBuffer();

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes(charsetName));
			byte[] hash = md.digest();

			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0"
							+ Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}


	/**
	 * 加密解密算法 执行一次加密，两次解密
	 */
	public static String convertMD5(String inStr){

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++){
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;

	}

	// 测试主函数
	public static void main(String args[]) {
//		String s = new String("tangfuqiangjiu"+ "tsest");
//		System.out.println("原始：" + s);

		String  a = convertMD5("81dc9bdb52d04dc20036dbd8313ed055");

		System.out.println("解密的：" + convertMD5(a));

//		String s =

		String pwdStr = "123456";
		String crypt = crypt(pwdStr);
//		System.out.println(crypt);

		String before ="xlh";
		String after = "fs";
		crypt = crypt(before+crypt+after);

		System.out.println(crypt);
	}



}
