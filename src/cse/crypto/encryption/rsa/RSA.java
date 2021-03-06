package cse.crypto.encryption.rsa;

import java.io.IOException;
import java.math.BigInteger;

import cse.crypto.helper.Debug;
import cse.crypto.helper.Utils;

/**
 * @author vrams
 *
 */
public class RSA {

	/** Encrypt the given plaintext message. */
	public static byte[] encrypt(byte[] message, Key publicKey) {
		return (new BigInteger(message)).modPow(publicKey.getKey(), publicKey.getN()).toByteArray();
	}

	/** Encrypt the given plaintext message. */
	public static BigInteger encrypt(BigInteger message, Key publicKey) {
		return message.modPow(publicKey.getKey(), publicKey.getN());
	}

	/** Decrypt the given ciphertext message. */
	public static byte[] decrypt(byte[] message, Key privateKey) {
		return (new BigInteger(message)).modPow(privateKey.getKey(), privateKey.getN()).toByteArray();
	}

	/** Decrypt the given ciphertext message. */
	public static BigInteger decrypt(BigInteger message, Key privateKey) {
		return message.modPow(privateKey.getKey(), privateKey.getN());
	}

	
	//TEST
	public static void main(String[] args) {
		Debug.d("START");
		try {
			KeyGenerator key = new KeyGenerator();
			key.savePrivateKey(Utils.DATA_DIR+"/rsa_private_key.key");
			key.savePublicKey(Utils.DATA_DIR+"/rsa_public_key.key");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Key publicKey = KeyGenerator.readKeyFromFile(Utils.DATA_DIR+"/rsa_private_key.key");
			Key privateKey = KeyGenerator.readKeyFromFile(Utils.DATA_DIR+"/rsa_public_key.key");		
						
			String text1 = "Ram �?iểu ususu 73737 DIEUDER g ô ơ  ê  nmdnnnd"
					+ "JJJDJJDJDJJDJJDJDJJ jJDJDJDJD"
					+ "DJJDJJDJD"
					+ "DKKKDKKD"
					+ "DKKDKDKKDKk"
					+ " Ơ UUW ƯU ";
			Debug.d("Plaintext", text1);

			byte[] ciphertext = RSA.encrypt(text1.getBytes(), publicKey);
			Debug.d("Encrypt");
			byte[] plaintext = RSA.decrypt(ciphertext, privateKey);

			String text2 = new String(plaintext);
			Debug.d("Plaintext", text2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
