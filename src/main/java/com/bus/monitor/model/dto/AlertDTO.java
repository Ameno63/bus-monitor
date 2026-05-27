package com.bus.monitor.model.dto;

import com.bus.monitor.model.enums.SensorType;
import com.bus.monitor.model.enums.Action;

public class AlertDTO {
    private SensorType sensorType;
    private Action action;
    private String message;
    
    public AlertDTO() {}
    
    public SensorType getSensorType() { return sensorType; }
    public void setSensorType(SensorType sensorType) { this.sensorType = sensorType; }
    public Action getAction() { return action; }
    public void setAction(Action action) { this.action = action; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}