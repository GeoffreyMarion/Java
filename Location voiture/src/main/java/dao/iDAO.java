package dao;

import java.util.ArrayList;

public interface iDAO <T> {
	public  boolean create(T objet);
	public ArrayList<T> read();
	public boolean delete(T object);
	public T findById(int id);
}