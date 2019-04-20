package com.citic.net.cipher.sm;

public class MyKeyPair {
	private String privateKey;
	private String publicKey;
	public MyKeyPair(String privateKey, String publicKey) {
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public String getPublicKey() {
		return publicKey;
	}
	
	

}
