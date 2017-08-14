package model;


public interface IFactory<T> {
	
	T instatiate(String ctrType, String[] args);
	
}