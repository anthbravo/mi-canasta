package com.micanasta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micanasta.model.Heartbeat;
import com.micanasta.repository.HeartbeatRepository;

@Service
public class HeartbeatServiceImpl implements HeartbeatService {

	@Autowired
	HeartbeatRepository heartbeatRepository;

	@Override
	public List<Heartbeat> getAll() {

		return heartbeatRepository.findAll();
	}

}
