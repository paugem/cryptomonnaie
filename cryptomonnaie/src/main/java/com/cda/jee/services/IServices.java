package com.cda.jee.services;

import java.util.ArrayList;

public interface IServices<T> {
	
	// List of the object
	public ArrayList<T> index();
	
	// Create one object
	public T create(T t);
	
	// Show one object
	public T read(int ID);
	
	// Edit one object
	public T update(T t);
	
	// Delete one object
	public void delete(int id);
	
}
