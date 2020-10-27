package com.agus.test.controller;

import com.agus.test.dao.EmployeeDao;
import com.agus.test.dto.CommonResponse;
import com.agus.test.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping(value = "/employee")
    public CommonResponse<Employee> addEmployee(@RequestBody Employee employee){
        List<Employee> employees = employeeDao.getByidNumber(employee.getIdNumber());
        CommonResponse<Employee> response = new CommonResponse<>();

        if (employee.getId() == null){
            if (employees.size() > 0){
                response.setResponseCode(21);
                response.setResponseMessage(String.format("NIP %s already exist", employee.getIdNumber()));
            }else {
                Employee empl = employeeDao.addEmployee(employee);
                response.setData(empl);
            }
        }else {
            Employee empl = employeeDao.addEmployee(employee);
            response.setData(empl);
        }
        return response;
    }

    @GetMapping(value = "/employees")
    public CommonResponse<List<Employee>> getEmployee(){
        CommonResponse<List<Employee>> commonResponse = new CommonResponse<>();
        List<Employee> empl = employeeDao.getAllEmployee();
        commonResponse.setData(empl);
        return commonResponse;
    }

    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable(value = "id") Integer id){
        Employee empl = employeeDao.getById(id);
        return new ResponseEntity<>(empl, HttpStatus.OK);
    }

    @PutMapping(value = "/employee")
    public ResponseEntity<?> getEmployee(@RequestBody Employee employee){
        Employee empl = employeeDao.update(employee);
        return new ResponseEntity<>(empl, HttpStatus.OK);
    }

    @DeleteMapping(value = "/employee/{id}")
    public CommonResponse<Employee> deleteEmployee(@PathVariable(value = "id") Integer id){
        Employee empl = employeeDao.delete(id);
        CommonResponse<Employee> response = new CommonResponse<>();
        response.setData(empl);
        return response;
    }
}
