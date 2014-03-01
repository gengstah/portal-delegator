package com.cacib.eurc.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cacib.eurc.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
	
	List<Log> findById(Long id);
	
	List<Log> findById(Long id, Pageable pageable);
	
	List<Log> findByApi(String api);
	
	List<Log> findByApi(String api, Pageable pageable);
	
	List<Log> findByMessageDirection(String messageDirection);
	
	List<Log> findByMessageDirection(String messageDirection, Pageable pageable);
	
	List<Log> findByApplicationCode(String applicationCode);
	
	List<Log> findByApplicationCode(String applicationCode, Pageable pageable);
	
}