package com.example.employee.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException  {


    @ExceptionHandler(Exception.class)
    public  void handleException(){

        System.out.println("Error");


    }



    @ExceptionHandler(ObjectNotfoundException.class)
    public  void handleObjectNotFoundException(){

        System.out.println("Object not found ");


    }

    @ExceptionHandler(AlreadyObjectFoundexception.class)
    public  void handleactNotFoundException(){

        System.out.println("Object Already exist ");


    }


}
