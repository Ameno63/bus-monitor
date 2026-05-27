package com.bus.monitor.model.dto;

import com.bus.monitor.model.enums.SensorType;
import java.time.LocalDateTime;

public class SensorDataDTO {
    private Long busId;
    private SensorType sensorType;
    private Double value;
    private LocalDateTime timestamp;
    
    public SensorDataDTO() {}
    
    public Long getBusId() { return busId; }
    public void setBusId(Long busId) { this.busId = busId; }
    public SensorType getSensorType() { return sensorType; }
    public void setSensorType(SensorType sensorType) { this.sensorType = sensorType; }
    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}