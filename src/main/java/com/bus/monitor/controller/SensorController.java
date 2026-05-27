package com.bus.monitor.controller;

import com.bus.monitor.model.SensorData;
import com.bus.monitor.model.dto.AlertDTO;
import com.bus.monitor.model.dto.SensorDataDTO;
import com.bus.monitor.service.SensorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {
    
    private final SensorService sensorService;
    
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }
    
    @PostMapping
    public ResponseEntity<SensorData> receiveSensorData(@RequestBody SensorDataDTO dto) {
        SensorData saved = sensorService.saveSensorData(dto);
        return ResponseEntity.ok(saved);
    }
    
    @GetMapping("/latest")
    public ResponseEntity<List<SensorData>> getLatest(@RequestParam Long busId) {
        return ResponseEntity.ok(sensorService.getLatestSensorData(busId));
    }
    
    @GetMapping("/history")
    public ResponseEntity<List<SensorData>> getHistory(
            @RequestParam Long busId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
        return ResponseEntity.ok(sensorService.getHistory(busId, from, to));
    }
    
    @GetMapping("/alerts")
    public ResponseEntity<List<AlertDTO>> getAlerts() {
        return ResponseEntity.ok(sensorService.getActiveAlerts());
    }
}