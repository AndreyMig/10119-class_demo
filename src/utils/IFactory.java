package utils;
import java.math.BigInteger;
import java.security.SecureRandom;


public interface IFactory<T> {
	
	T instatiate(String ctrType, String[] args);
}
