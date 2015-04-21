package com.sri.bolid;


import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;



@Stateless
public class WiadomoscSender{
	  
	/*	@Inject 
		JMSContext context;
	    

		 @Resource(lookup = "java:/queue/myqueue")
	    Queue queue;

	    public void sendMessage(String message) {
	        context.createProducer().send(queue, message);
	    }*/
}
