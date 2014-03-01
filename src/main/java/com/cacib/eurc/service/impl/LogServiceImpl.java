package com.cacib.eurc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cacib.eurc.dao.LogRepository;
import com.cacib.eurc.model.Log;
import com.cacib.eurc.service.LogService;

public class LogServiceImpl extends AbstractDelegatorService<Log, Long> implements LogService {
	
	@Inject private LogRepository logRepository;
	
	public LogServiceImpl() { }

	@Override
	public JpaRepository<Log, Long> getRepository() {
		return logRepository;
	}

	public List<Log> findById(Long id) {
		return logRepository.findById(id);
	}

	public List<Log> findById(Long id, Pageable pageable) {
		return logRepository.findById(id, pageable);
	}

	public List<Log> findByApi(String api) {
		return logRepository.findByApi(api);
	}

	public List<Log> findByApi(String api, Pageable pageable) {
		return logRepository.findByApi(api, pageable);
	}

	public List<Log> findByMessageDirection(String messageDirection) {
		return logRepository.findByMessageDirection(messageDirection);
	}

	public List<Log> findByMessageDirection(String messageDirection, Pageable pageable) {
		return logRepository.findByMessageDirection(messageDirection, pageable);
	}

	public List<Log> findByApplicationCode(String applicationCode) {
		return logRepository.findByApplicationCode(applicationCode);
	}

	public List<Log> findByApplicationCode(String applicationCode, Pageable pageable) {
		return logRepository.findByApplicationCode(applicationCode, pageable);
	}
	
}