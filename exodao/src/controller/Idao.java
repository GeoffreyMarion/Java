package controller;

import java.util.ArrayList;

public interface Idao <T> {
	public boolean create(T objet);
	public ArrayList<T> read();
	public T update(T object);
	public boolean delete(T object);
	public T findById(int id);
	public T findByEmail(String email);
	public ArrayList<T> findByNom(String nom);
}
