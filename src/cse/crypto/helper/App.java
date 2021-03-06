package cse.crypto.helper;

import cse.crypto.encryption.Cryptor;
import cse.crypto.encryption.DAESCryptor;
import cse.crypto.encryption.RSACryptor;

public class App {
	
	private static AlgType sendAlgName = AlgType.RSA;
	
	//RSA
	public final static int RSA_KEY_LEN = 64 * 8;
	public final static int RSA_SENDING_BUFFER = 32;
	
	//AES
	public final static int AES_KEY_LEN = 128;
	public final static int AES_IV_LEN = 16;
	public final static int AES_SENDING_BUFFER = 1024;
	
	//DES
	public final static int DES_KEY_LEN = 56;
	public final static int DES_IV_LEN = 8;
	public final static int DES_SENDING_BUFFER = 1024;


	
	public enum AlgType{
		RSA("RSA"),
		DES("DES"),
		AES("AES");
		
		final String name;
		AlgType(String name){
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
	public static AlgType getSendingAlgName() {
		return sendAlgName;
	}
	
	public static void setSendingAlgName(AlgType algName) {
		sendAlgName = algName;
	}
	
	public static Cryptor getSendingCryptor(){
		Cryptor cryptor = null;
		switch (sendAlgName) {
		case RSA:
			cryptor = new RSACryptor();
			Debug.d("getSendingCryptor", "RSA");
			break;
		case DES:
			cryptor = new DAESCryptor(AlgType.DES);
			Debug.d("getSendingCryptor", "DES");
			break;
		case AES:
			cryptor = new DAESCryptor(AlgType.AES);
			Debug.d("getSendingCryptor", "AES");
			break;
		default:
			cryptor = new RSACryptor();
			Debug.d("getSendingCryptor", "sw default");
			break;
		}
		
		return cryptor;
	}
	
	public static Cryptor getCryptor(AlgType type){
		Cryptor cryptor = null;
		switch (type) {
		case RSA:
			cryptor = new RSACryptor();
			Debug.d("getDownloadingCryptor", "RSA");
			break;
		case DES:
			cryptor = new DAESCryptor(AlgType.DES);
			Debug.d("getDownloadingCryptor", "DES");
			break;
		case AES:
			cryptor = new DAESCryptor(AlgType.AES);
			Debug.d("getDownloadingCryptor", "AES");
			break;
		default:
			cryptor = new RSACryptor();
			Debug.d("getDownloadingCryptor", "sw default");
			break;
		}
		
		return cryptor;
	}
	

}
