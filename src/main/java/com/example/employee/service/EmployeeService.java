package com.example.employee.service;

import com.example.employee.exception.ObjectNotfoundException;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;


    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }


    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }



    //ObjectNotfoundException objectNotfoundException = new ObjectNotfoundException("kkkkk");

    public Employee getEmployeeById(int id){
         Employee employee = employeeRepository.findById(id).orElseThrow(
                 () -> new ObjectNotfoundException("Object is not found")
        );

         return  employee;
    }


    public Optional<List<Employee>> getEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }
    public void deleteEmployeeById(int id){
        employeeRepository.deleteById(id);
    }
    public void deleteEmployee(Employee employee){
        employeeRepository.delete(employee);
    }

    public List<Employee> getEmployeebyasc(){
        return employeeRepository.getnamewithascorder();
    }
}
