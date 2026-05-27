package com.bus.monitor.service;

import com.bus.monitor.model.Bus;
import com.bus.monitor.model.SensorData;
import com.bus.monitor.model.dto.AlertDTO;
import com.bus.monitor.model.dto.SensorDataDTO;
import com.bus.monitor.model.enums.Action;
import com.bus.monitor.model.enums.SensorType;
import com.bus.monitor.repository.BusRepository;
import com.bus.monitor.repository.SensorDataRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorService {
    
    private final SensorDataRepository sensorDataRepository;
    private final BusRepository busRepository;
    
    public SensorService(SensorDataRepository sensorDataRepository, BusRepository busRepository) {
        this.sensorDataRepository = sensorDataRepository;
        this.busRepository = busRepository;
    }
    
    public SensorData saveSensorData(SensorDataDTO dto) {
        Bus bus = busRepository.findById(dto.getBusId())
                .orElseThrow(() -> new RuntimeException("Bus not found"));
        
        SensorData data = new SensorData();
        data.setBus(bus);
        data.setSensorType(dto.getSensorType());
        data.setValue(dto.getValue());
        data.setTimestamp(dto.getTimestamp() != null ? dto.getTimestamp() : LocalDateTime.now());
        data.setAnomaly(checkAnomaly(dto.getSensorType(), dto.getValue()));
        
        return sensorDataRepository.save(data);
    }
    
    public List<SensorData> getLatestSensorData(Long busId) {
        return sensorDataRepository.findByBusIdOrderByTimestampDesc(busId)
                .stream()
                .limit(10)
                .collect(Collectors.toList());
    }
    
    public List<SensorData> getHistory(Long busId, LocalDateTime from, LocalDateTime to) {
        return sensorDataRepository.findByBusIdAndTimestampBetween(busId, from, to);
    }
    
    public List<AlertDTO> getActiveAlerts() {
        List<SensorData> anomalies = sensorDataRepository.findByAnomalyTrue();
        
        return anomalies.stream()
                .limit(20)
                .map(data -> {
                    AlertDTO alert = new AlertDTO();
                    alert.setSensorType(data.getSensorType());
                    alert.setAction(Action.warning);
                    alert.setMessage("Аномалия: " + data.getSensorType() + " = " + data.getValue());
                    return alert;
                })
                .collect(Collectors.toList());
    }
    
    private boolean checkAnomaly(SensorType type, Double value) {
        switch (type) {
            case engine_temp:
                return value > 105.0 || value < 70.0;
            case tire_pressure:
                return value > 3.5 || value < 2.0;
            case fuel_level:
                return value < 10.0;
            case speed:
                return value > 100.0;
            default:
                return false;
        }
    }
}