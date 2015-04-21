package com.sri.bolid;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
		name = "myqueue", 
				activationConfig =   {
				 @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/myqueue"),
				  @ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),  
				@ActivationConfigProperty(propertyName="destination", propertyValue="java:/queue/myqueue")
				}
				
				) 



public class WiadomoscConsumer implements MessageListener {
  @Override
  public void onMessage(Message message) {
	  TextMessage msg = null;
	  if (message instanceof TextMessage) {
		  msg = (TextMessage) message;
		  try {
			System.out.println("HEJ!!!: "+msg.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
      System.out.println("Wiadomosc zostala odebrana: ");
  }
}
