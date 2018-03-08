package com.apft.utils;

import java.io.*;
import java.nio.ByteBuffer;

public class Encrypt {
	
	public static final String ENC_KEY = "e";
	public static final int QLFG_KEY = 0x9a7b5c3d;
	
	private static final int FRAME_HEAD = 0xabcd;
	private static final int FRAME_HEADEx = 0xbcde;
	
	
	private static final int ENCRYPT_VER = 0x3d9a32b7;

	private static byte [] Encrypt(byte [] btData, int uKey)
	{
		return Encrypt(btData, uKey, 0, btData.length);
	}

	

	private static byte [] Encrypt(byte [] btData, int uKey, int off, int len)
	{
		
		
		for(int i=off; i<off+len; i++){
			btData[i] = (byte)(btData[i] ^ ( ~( (uKey*(i-off)) ^ (ENCRYPT_VER/(((i-off)%7+1))) ) ));
		}
		return btData;
	}
	
	private static byte [] Encrypt(String str, int uKey)
	{
		byte[] btData;
		try {
			btData = str.getBytes("utf-8");
			return Encrypt(btData,uKey,0,btData.length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte [] FrameEncrypt(String str, int uKey) throws IOException{
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);
		
		byte [] btData = Encrypt.Encrypt(str, uKey);
		int nCRC16 = CRC16.doCRC16(btData);
		
		int nFrameHead = FRAME_HEAD;
		int len = btData.length;
		
		if ((len&0xffff0000) != 0){
			nFrameHead = FRAME_HEADEx;
		}
		
		
		dos.writeShort(nFrameHead);
		dos.writeInt(nCRC16);
		if (nFrameHead == FRAME_HEADEx)
			dos.writeInt(len);
		else
			dos.writeShort(len);
		dos.write(btData);
		
		byte [] ret = baos.toByteArray();
		
		dos.close();
		baos.close();
		
		return ret;
		
//		ByteBuffer bBuf = ByteBuffer.allocate(str.length()*3+10);
//		byte [] btData = Encrypt.Encrypt(str, uKey);
//		int nCRC16 = CRC16.doCRC16(btData);
//		bBuf.putInt(nCRC16);
//		bBuf.putShort((short)btData.length);
//		bBuf.put(btData);
//	
//		return bBuf.array();
		
	}
	

	
	public static String FrameDecrypt(byte []btData, int uKey) throws IOException{
		ByteArrayInputStream bais = new ByteArrayInputStream(btData);
		DataInputStream dis = new DataInputStream(bais);
		
		int nFrameHead = 0xffff&dis.readShort();
		if (!(nFrameHead == FRAME_HEAD || nFrameHead == FRAME_HEADEx)){
			return null;
		}
		int nCRC16 = dis.readInt();
		
		int len = 0;
		if (nFrameHead==FRAME_HEAD){
			len = dis.readShort();
			len &= 0xffff;
		}else{
			len = dis.readInt();
		}
		

		
		byte [] btTmp = new byte[len];
		dis.read(btTmp);

		dis.close();
		bais.close();		

		int nCRC2 = CRC16.doCRC16(btTmp);
		if (nCRC2 == nCRC16){
			btTmp = Encrypt(btTmp, uKey);
			return new String(btTmp , "utf-8");
		}
		return null;
	}	
	
	
	public static void main(String [] argv){
		
//		int UKEY = 0x12345678;
		String str = "12345678";

		
		try {
			byte []btData = Encrypt.FrameEncrypt(str, QLFG_KEY);
			
			String ret = FrameDecrypt(btData,QLFG_KEY);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
