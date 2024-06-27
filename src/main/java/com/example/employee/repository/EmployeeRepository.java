package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee , Integer> {

    public Optional<List<Employee>> findByName(String name);


    @Query("select E from Employee E order by E.name asc")
    public List<Employee> getnamewithascorder();
}