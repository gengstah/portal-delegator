package com.cacib.eurc.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cacib.eurc.service.DelegatorService;

public abstract class AbstractDelegatorService<T, ID extends Serializable> implements DelegatorService<T, ID> {
	
	private JpaRepository<T, ID> repository;
	
	public T save(T t) {
		return repository.save(t);
	}
	
	public T update(T t) {
		return save(t);
	}
	
	public void delete(T t) {
		repository.delete(t);
	}
	
	public T search(ID id) {
		return repository.findOne(id);
	}
	
	public List<T> findAll() {
		return repository.findAll();
	}

	/**
	 * @return the repository
	 */
	public abstract JpaRepository<T, ID> getRepository();
	
}