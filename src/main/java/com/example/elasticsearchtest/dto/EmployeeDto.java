package com.example.elasticsearchtest.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class EmployeeDto {

    private String id;
    private String name;
    private String department;

    public EmployeeDto(String id, String name, String department) {
        super();
        this.setId(id);
        this.name = name;
        this.department = department;
    }

    public EmployeeDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
