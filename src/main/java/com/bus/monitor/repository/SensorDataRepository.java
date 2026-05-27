package com.bus.monitor.repository;

import com.bus.monitor.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    
    List<SensorData> findByBusIdAndTimestampBetween(Long busId, LocalDateTime from, LocalDateTime to);
    
    List<SensorData> findByAnomalyTrue();
    
    List<SensorData> findByBusIdOrderByTimestampDesc(Long busId);
}