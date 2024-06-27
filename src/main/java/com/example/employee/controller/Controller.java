package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.model.ResponseDto;
import com.example.employee.service.EmployeeService;
import com.example.employee.validation.EmployeeValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@Validated
public class Controller {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeValidation employeeValidation;

    @PostMapping("/createemployee")
    public ResponseEntity<ResponseDto> createEmployee(@Valid @RequestBody Employee employee) {
     ResponseDto responseDto = new ResponseDto();
     List<String> errorList = new ArrayList<>();
        Employee employee1 = null;
        employeeValidation.validEmployee(employee,errorList);

        if (errorList.size() > 0){
            responseDto.setStatusMessage(errorList.toString());
            return ResponseEntity.status(HttpStatus.OK
            ).body(responseDto);
        } else {
            employee1 = employeeService.createEmployee(employee);
            responseDto.setStatuscode("200");
            responseDto.setStatusMessage("Created");
            responseDto.setEmployee(employee);

        }



        return ResponseEntity.status(HttpStatus.OK
        ).body(responseDto);
      //  return employeeService.createEmployee(employee);
    }
    @GetMapping("/getemployee")
    public List<Employee> getEmployee(){




        return employeeService.getEmployee();
    }
    @GetMapping("/getemployeebyid/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }


    @GetMapping("/getemployeebyname/{name}")
    public Optional<List<Employee>> getEmployeeByName(@PathVariable String name){
        return employeeService.getEmployeeByName(name);
    }

    @DeleteMapping("/deleteemployee")
    public void deleteEmployee(@RequestBody Employee employee){
       // Employee employee1=null;
       /* if(employeeValidation.validEmployee(employee)){
            employeeService.deleteEmployee(employee);
        } else{
            throw new RuntimeException("delete");
        }*/

        employeeService.deleteEmployee(employee);
    }
    @DeleteMapping("/deleteemployeebyid/{id}")
    public void deleteEmployeeById(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/getemployeeasc")
    public List<Employee> getEmployeeasc(){
        return employeeService.getEmployeebyasc();
    }
}

