package com.micanasta.controller;
import java.util.List;


import com.micanasta.model.Heartbeat;
import com.micanasta.service.HeartbeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heartbeat")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
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
