package com.test.khs;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ClientTest {

	@Test
	public void test() {
    	Client c = new Client();
    	
    	Item i = new Item();
    	i.content = "hehe";
    	i.id = 1234;

    	List<Item> list = new LinkedList<Item>();
    	list.add(i);
    	
    	c.write(list);
	}

}
