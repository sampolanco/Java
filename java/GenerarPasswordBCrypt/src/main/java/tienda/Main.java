package tienda;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
	SecureRandom random=new SecureRandom("clavepassword".getBytes());
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11,random);
	
	public static String getHash(String texto) {
		//String salt="$2a$10$fK3S2vZaP/4y.z5h8in16O";
		String salt=BCrypt.gensalt();
		String textoHash= BCrypt.hashpw(texto.getBytes(), salt);
		return textoHash;
	}

	public static void main(String[] args) {
		String hash=getHash("cajero");
		boolean plainVsHash=BCrypt.checkpw("123", hash);
		System.out.println("hash: "+hash);
		System.out.println("plain vs hash: "+plainVsHash);

	}

}
