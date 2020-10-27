package com.agus.test.dao;

import com.agus.test.dto.EmployeeDTO;
import com.agus.test.dto.TableRequest;
import com.agus.test.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getById(Integer id);
    Employee update(Employee employee);
    Employee delete(Integer id);
    List<Employee> getByidNumber(Integer id);
}
