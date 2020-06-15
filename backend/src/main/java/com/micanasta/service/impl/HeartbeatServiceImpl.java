package com.micanasta.service.impl;

import com.micanasta.model.Heartbeat;
import com.micanasta.repository.HeartbeatRepository;
import com.micanasta.service.HeartbeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartbeatServiceImpl implements HeartbeatService {

    @Autowired
    HeartbeatRepository heartbeatRepository;

    @Override
    public List<Heartbeat> getAll() {

        return heartbeatRepository.findAll();
    }

}
