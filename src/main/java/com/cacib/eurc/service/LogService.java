package com.cacib.eurc.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cacib.eurc.model.Log;

public interface LogService extends DelegatorService<Log, Long> {
	
	List<Log> findById(Long id);
	
	List<Log> findById(Long id, Pageable pageable);
	
	List<Log> findByApi(String api);
	
	List<Log> findByApi(String api, Pageable pageable);
	
	List<Log> findByMessageDirection(String messageDirection);
	
	List<Log> findByMessageDirection(String messageDirection, Pageable pageable);
	
	List<Log> findByApplicationCode(String applicationCode);
	
	List<Log> findByApplicationCode(String applicationCode, Pageable pageable);
	
}