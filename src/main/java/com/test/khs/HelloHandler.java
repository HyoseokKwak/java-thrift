package com.test.khs;


import org.apache.thrift.TException;

public class HelloHandler implements HelloService.Iface{
 public String greeting(String name, int age) throws TException{
  return "Hello " + name + ". You are " + age + " years old";
 }
}