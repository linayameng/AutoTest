package com.tester.model;

import lombok.Data;

@Data
public class User {
        private int id;
        private String name;
        private String password;
        private int age;
        private String token;


        @Override
        public String toString(){
              return (
              "id:"+id+","+
              "userName:"+name+","+
              "password:"+password+","+
              "age:"+age+","+
              "permission:"+token
              );
        }
}
