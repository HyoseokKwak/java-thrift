package com.test.khs;

import java.util.List;

//Need to implement the interface defined in CrawlingService
public class CrawlingHandler implements CrawlingService.Iface {
 public void write(List<Item> items) throws org.apache.thrift.TException {
     for (Item item : items) {
         System.out.println(item.toString());
     }
 }
}