package com.test.khs;

import java.util.LinkedList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class Client {
    public void write(List<Item> items){
        TTransport transport;
        try {
            transport = new TSocket("192.168.56.1", 7911);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            CrawlingService.Client client = new CrawlingService.Client(protocol);

            client.write(items);
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    	
    	Client c = new Client();
    	
    	Item i = new Item();
    	i.content = "hehe";
    	i.id = 123;

    	List<Item> list = new LinkedList<Item>();
    	list.add(i);
    	
    	c.write(list);
	}
}