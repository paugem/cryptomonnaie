package com.cda.jee.dao;

import java.util.ArrayList;

public interface IDAO<T> {
	
	// List of the object
	public ArrayList<T> getAll();
	
	// Create one object
	public T add(T t);
		
	// Show one object
	public T getById(int id);
	
	//Show one object
	public T getByName(String name);
	
	// Edit one object
	public T updateById(T t);
	
	// Delete one object
	public void deleteById(int id);
		
}
