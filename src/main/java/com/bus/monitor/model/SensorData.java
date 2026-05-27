package com.bus.monitor.model;

import com.bus.monitor.model.enums.SensorType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_data")
public class SensorData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "bus_id")
    @JsonIgnore
    private Bus bus;
    
    @Enumerated(EnumType.STRING)
    private SensorType sensorType;
    
    private Double value;
    
    private LocalDateTime timestamp;
    
    private boolean anomaly;
    
    public SensorData() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Bus getBus() {
        return bus;
    }
    
    public void setBus(Bus bus) {
        this.bus = bus;
    }
    
    public SensorType getSensorType() {
        return sensorType;
    }
    
    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }
    
    public Double getValue() {
        return value;
    }
    
    public void setValue(Double value) {
        this.value = value;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public boolean isAnomaly() {
        return anomaly;
    }
    
    public void setAnomaly(boolean anomaly) {
        this.anomaly = anomaly;
    }
}