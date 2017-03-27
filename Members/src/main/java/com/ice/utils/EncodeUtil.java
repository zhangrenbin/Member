package com.ice.utils;

import java.security.MessageDigest;

import org.apache.xerces.impl.dv.util.Base64;

public class EncodeUtil {

	public static String md5AndBase64(String src) {
		byte buf[] = src.getBytes();
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(buf);
            byte[] digest = algorithm.digest();
            for (int i = 0; i < digest.length; i++)
            {
                hexString.append(pad(Integer.toHexString(0xFF & digest[i]) , 2));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String md5 = hexString.toString();
        //base64转码
		String dstStr = Base64.encode(md5.getBytes());
		return dstStr;
	}
	
	 /**
     * 在字符串之前补0
     *
     * @param i
     * @param l
     * @return
     */
    public static String pad(String i , int l)
    {
        while (i.length() < l)
        {
            i = '0' + i;
        }
        return i;
    }

    public static void main(String[] args) {
		String s = "123456";
		s = EncodeUtil.md5AndBase64(s);
		System.out.println(s);
	}
}
