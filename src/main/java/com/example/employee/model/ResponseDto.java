package com.example.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor

@NoArgsConstructor


public class ResponseDto {

    private  String statuscode;

    private String statusMessage;

    private Employee employee;

   public ResponseDto(String statuscode, String statusMessage) {
       this.statuscode = statuscode;
      this.statusMessage = statusMessage;
  }
}
