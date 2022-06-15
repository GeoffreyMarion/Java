package DAO;

import java.util.ArrayList;

public interface iDAO <T> {
	public  boolean create(T objet);
	public ArrayList<T> read();
	public T update(T object);
	public boolean delete(T object);
	public T findById(int id);
	public ArrayList<T> findByNom(String nom);
}
