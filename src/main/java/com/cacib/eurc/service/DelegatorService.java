package com.cacib.eurc.service;

import java.util.List;

public interface DelegatorService<T, ID> {
	
	T save(T t);
	
	T update(T t);
	
	void delete(T t);
	
	T search(ID id);
	
	List<T> findAll();
	
}