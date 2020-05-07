package com.micanasta.service.impl;

import java.util.List;

import com.micanasta.service.HeartbeatService;
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
