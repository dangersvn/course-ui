package com.example.courses_management_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// @Data
@AllArgsConstructor
public class Employee {
    Integer id;

    String name;
    
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id.equals(employee.id) && name.equals(employee.name);
        }
    
        // @Override
        // public int hashCode() {
        //     return java.util.Objects.hash(id, name);
        // }


}
