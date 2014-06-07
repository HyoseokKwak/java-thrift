package com.test.khs;

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
            transport = new TSocket("localhost", 7911);
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
}