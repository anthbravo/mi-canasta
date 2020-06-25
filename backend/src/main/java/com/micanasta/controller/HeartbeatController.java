package com.micanasta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micanasta.model.Heartbeat;
import com.micanasta.service.HeartbeatService;

@RestController
@RequestMapping("/heartbeat")
public class HeartbeatController {

    @Autowired
    HeartbeatService heartbeatService;

    @GetMapping()
    public ResponseEntity<List<Heartbeat>> getAll() {

        List<Heartbeat> heartbeats = heartbeatService.getAll();

        if (heartbeats.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(heartbeats);
        }

    }
}
