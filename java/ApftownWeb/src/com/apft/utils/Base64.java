package com.apft.utils;

import java.io.*;

/*
 * 非标准base64
 * */
public class Base64 {
    private final static char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~^".toCharArray();

    private static int[]  toInt   = new int[128];

    static {
        for(int i=0; i< ALPHABET.length; i++){
            toInt[ALPHABET[i]]= i;
        }
    }

    /**
     * Translates the specified byte array into Base64 string.
     *
     * @param buf the byte array (not null)
     * @return the translated Base64 string (not null)
     */
    public static String encode(byte[] buf){
        int size = buf.length;
        char[] ar = new char[((size + 2) / 3) * 4];
        int a = 0;
        int i=0;
        while(i < size){
            byte b0 = buf[i++];
            byte b1 = (i < size) ? buf[i++] : 0;
            byte b2 = (i < size) ? buf[i++] : 0;

            int mask = 0x3F;
            ar[a++] = ALPHABET[(b0 >> 2) & mask];
            ar[a++] = ALPHABET[((b0 << 4) | ((b1 & 0xFF) >> 4)) & mask];
            ar[a++] = ALPHABET[((b1 << 2) | ((b2 & 0xFF) >> 6)) & mask];
            ar[a++] = ALPHABET[b2 & mask];
        }
        switch(size % 3){
            case 1: ar[--a]  = '=';
            case 2: ar[--a]  = '=';
        }
        return new String(ar);
    }

    /**
     * Translates the specified Base64 string into a byte array.
     *
     * @param s the Base64 string (not null)
     * @return the byte array (not null)
     */
    public static byte[] decode(String s){
        int delta = s.endsWith( "==" ) ? 2 : s.endsWith( "=" ) ? 1 : 0;
        byte[] buffer = new byte[s.length()*3/4 - delta];
        int mask = 0xFF;
        int index = 0;
        for(int i=0; i< s.length(); i+=4){
            int c0 = toInt[s.charAt( i )];
            int c1 = toInt[s.charAt( i + 1)];
            buffer[index++]= (byte)(((c0 << 2) | (c1 >> 4)) & mask);
            if(index >= buffer.length){
                return buffer;
            }
            int c2 = toInt[s.charAt( i + 2)];
            buffer[index++]= (byte)(((c1 << 4) | (c2 >> 2)) & mask);
            if(index >= buffer.length){
                return buffer;
            }
            int c3 = toInt[s.charAt( i + 3 )];
            buffer[index++]= (byte)(((c2 << 6) | c3) & mask);
        }
        return buffer;
    } 

    
    
    
    
    
    
    /**
	 * javaScript escape 编码
	 * @param src
	 * @return
	 */
	public static String escape(String src) {  
        int i;  
        char j;  
        StringBuffer tmp = new StringBuffer();  
        tmp.ensureCapacity(src.length() * 6);  
        for (i = 0; i < src.length(); i++) {  
            j = src.charAt(i);  
            if (Character.isDigit(j) || Character.isLowerCase(j)  
                    || Character.isUpperCase(j))  
                tmp.append(j);  
            else if (j < 256) {  
                tmp.append("%");  
                if (j < 16)  
                    tmp.append("0");  
                tmp.append(Integer.toString(j, 16));  
            } else {  
                tmp.append("%u");  
                tmp.append(Integer.toString(j, 16));  
            }  
        }  
        return tmp.toString();  
    }  
 
	/**
	 * javaScript unescape 解码
	 * @param src
	 * @return
	 */
    public static String unescape(String src) {  
        StringBuffer tmp = new StringBuffer();  
        tmp.ensureCapacity(src.length());  
        int lastPos = 0, pos = 0;  
        char ch;  
        while (lastPos < src.length()) {  
            pos = src.indexOf("%", lastPos);  
            if (pos == lastPos) {  
                if (src.charAt(pos + 1) == 'u') {  
                    ch = (char) Integer.parseInt(src  
                            .substring(pos + 2, pos + 6), 16);  
                    tmp.append(ch);  
                    lastPos = pos + 6;  
                } else {  
                    ch = (char) Integer.parseInt(src  
                            .substring(pos + 1, pos + 3), 16);  
                    tmp.append(ch);  
                    lastPos = pos + 3;  
                }  
            } else {  
                if (pos == -1) {  
                    tmp.append(src.substring(lastPos));  
                    lastPos = src.length();  
                } else {  
                    tmp.append(src.substring(lastPos, pos));  
                    lastPos = pos;  
                }  
            }  
        }  
        return tmp.toString();  
    }  
}


























/*package com.qlfg.zlutils;

import java.io.*;

public class Base64 {
	public Base64() {
	}


//	static final private String _base64_encode_chars[] =
//		 "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

	 static final private char [] _base64_encode_chars = {
		 'A','B','C','D','E','F','G','H','I','J','K','L','M',
		 'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
		 'a','b','c','d','e','f','g','h','i','j','k','l','m',
		 'n','o','p','q','r','s','t','u','v','w','x','y','z',
		 '0','1','2','3','4','5','6','7','8','9','~','^'
	 };

	static public String encode(byte[] in_str)
	{
		int len = 0;
//		byte[] in_str = null;

		try {
			in_str = strIn.getBytes("utf-8");
			len = in_str.length;
		} catch (UnsupportedEncodingException ex) {
		}
		
		len = in_str.length;
		StringBuffer out_str = new StringBuffer();
		char c1, c2, c3;
		int i = 0;

		while ( i<len )
		{
			// read the first byte
			c1 = (char)(0xff&in_str[i++]);
			if ( i==len )       // pad with "="
			{
				out_str.append(_base64_encode_chars[ c1>>2 ]);
				out_str.append( _base64_encode_chars[ (c1&0x3)<<4 ]);
				out_str.append("==");
				break;
			}

			// read the second byte
			c2 = (char)(0xff&in_str[i++]);
			if ( i==len )       // pad with "="
			{
				out_str.append(_base64_encode_chars[ c1>>2 ]);
				out_str.append(_base64_encode_chars[ ((c1&0x3)<<4) | ((c2&0xF0)>>4) ]);
				out_str.append(_base64_encode_chars[ (c2&0xF)<<2 ]);
				out_str.append("=");
				break;
			}

			// read the third byte
			c3 = (char)(0xff&in_str[i++]);
			// convert into four bytes string
			out_str.append(_base64_encode_chars[ c1>>2 ]);
			out_str.append(_base64_encode_chars[ ((c1&0x3)<<4) | ((c2&0xF0)>>4) ]);
			out_str.append(_base64_encode_chars[ ((c2&0xF)<<2) | ((c3&0xC0)>>6) ]);
			out_str.append(_base64_encode_chars[ c3&0x3F ]);
		}

		return out_str.toString();
	}


private static final int ENCRYPT_VER = 0x3d9a32b7;

	public static byte [] Encrypt(byte [] btData, int uKey)
	{
		for(int i=0; i<btData.length; i++){
			btData[i] = (byte)(btData[i] ^ ( ~( (uKey*i) ^ (ENCRYPT_VER/((i%7+1))) ) ));
		}
		return btData;
	}

	public static byte [] UnEncrypt(byte [] btData, int uKey)
	{
		for(int i=0; i<btData.length; i++){
			btData[i] = (byte)(btData[i] ^ ( ~( (uKey*i) ^ (ENCRYPT_VER/((i%7+1))) ) ));
		}
		return btData;
	}


	public static void main(String args[])
	{
//		String strSrc = "127.0.0.1:9898:�ҵ�����\\�ҵĸ���;127.0.0.137:9898:�ҵ�����\\�ҵ�MIDI;";//�ļ�����·����
		String strSrc = "192.168.0.19:9888:�ҵĸ���;";//�ļ�����·����
//		String strSrc = "��";//�ļ�����·����
		byte [] in_str =null;
		try {
			in_str = strSrc.getBytes("utf-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		  String strBase54 = encode(strSrc);

	}

}
*/