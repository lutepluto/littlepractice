package jiecao.chat.servlet;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import jiecao.chat.websocket.DiscardServer;
import jiecao.chat.websocket.WebSocketServer;


public class ChatInitServlet extends HttpServlet {

	private static final long serialVersionUID = 4902252448400282961L;
	
	private static final Logger logger = Logger.getLogger(ChatInitServlet.class.getName());

	@Override
	public void init() throws ServletException {
//		try {
//			WebSocketServer.getInstance();
//		} catch(Exception e) {
//			logger.log(Level.SEVERE, "Fail to init the chatroom server!");
//			throw new ServletException();
//		}
		try{
			Runnable server = new DiscardServer();
			Thread t = new Thread(server);
			t.start();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
