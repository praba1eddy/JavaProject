package com.example.employee.validation;

import com.example.employee.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class EmployeeValidation {

    public  void validEmployee(Employee employee, List<String> errorList){


        String nameregix = ".*\\d.*"; // asd12dfr  12asdfg  hjkhkgh12
        boolean isvalid =true;
        if(!ObjectUtils.isEmpty(employee)){

            if(employee.getName().isBlank()){
                isvalid=false;
            } else if (employee.getName().matches(nameregix)) {
                isvalid = false;
            }
            if (!isvalid){
                errorList.add("Name Should not be empty");

            }
            if(employee.getAddress().isEmpty()){
                isvalid=false;
                errorList.add("Address should not be empty");
            }
        }

    }
    public boolean voildEmployeeid(Employee employee){
       boolean isvalid=true;
       if(!ObjectUtils.isEmpty(employee)){

           if(employee.getName().isEmpty()){

               isvalid=false;

           }
           if(employee.getAddress().isEmpty()){
               isvalid=true;
           }


       }
        return isvalid;
    }

}
