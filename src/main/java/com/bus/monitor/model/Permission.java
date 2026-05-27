package com.bus.monitor.model;

import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String permission;
    private String operation;
    
    public Permission() {}
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPermission() { return permission; }
    public void setPermission(String permission) { this.permission = permission; }
    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }
}