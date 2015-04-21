package com.sri.bolid;



import java.io.IOException;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Test
 */



@JMSDestinationDefinition(
		name = "java:/queue/myqueue",
		destinationName="myqueue",
		interfaceName = "javax.jms.Queue"
)

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	 @Inject
	 private JMSContext context;
	
	 @Resource(lookup = "java:/queue/myqueue")
	private Queue queue;
	

    /**
     * Default constructor. 
     */
    public Test() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		 context.createProducer().send(queue,"testowa wiadomosc Mariiusza");
		 System.out.println("wiadomosc została wysłana");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context.createProducer().send(queue, "Mariusz ");
		System.out.println("doPost");
	}

}
