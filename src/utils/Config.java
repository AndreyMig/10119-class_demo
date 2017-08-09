package utils;
import java.math.BigInteger;
import java.security.SecureRandom;


public class Config {
	
	
	
	
	public static String generateUUID() {
	    SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
}
