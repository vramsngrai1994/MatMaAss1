package cse.crypt.helper;

import cse.crypt.encryption.Cryptor;
import cse.crypt.encryption.DAESCryptor;
import cse.crypt.encryption.RSACryptor;

public class App {
	
	private static AlgType sendAlgName = AlgType.RSA;
	private static AlgType downloadAlgName = AlgType.RSA;
	
	//RSA
	public static int RSA_KEY_LEN = 64 * 8;
	
	//AES
	public static int AES_KEY_LEN = 128;
	
	//DES
	public static int DES_KEY_LEN = 56;


	
	public enum AlgType{
		RSA,
		DES,
		AES
	}
	
	public static AlgType getSendingAlgName() {
		return sendAlgName;
	}
	
	public static void setSendingAlgName(AlgType algName) {
		sendAlgName = algName;
	}
	
	public static void setDownloadingAlgName(AlgType receiveAlgName) {
		downloadAlgName = receiveAlgName;
	}
	
	public static AlgType getDownloadingAlgName() {
		return downloadAlgName;
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
	
	public static Cryptor getDownloadingCryptor(){
		Cryptor cryptor = null;
		switch (downloadAlgName) {
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