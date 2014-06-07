package com.test.khs;

import javax.security.auth.login.Configuration;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class Server {

	public void start(Configuration conf) {
		try {
			// Set port
			TServerSocket serverTransport = new TServerSocket(7911);
			// Set CrawlingHandler we defined before
			// to processor, which handles RPC calls
			// Remember, one service per server
			CrawlingHandler handler = new CrawlingHandler();
			CrawlingService.Processor<CrawlingService.Iface> processor = new CrawlingService.Processor<CrawlingService.Iface>(
					handler);

			TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(
					serverTransport).processor(processor));

			System.out.println("Starting server on port 7911 ...");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Server server = new Server();
		server.start(null);
	}

}
