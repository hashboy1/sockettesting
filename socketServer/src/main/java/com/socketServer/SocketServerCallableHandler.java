package com.socketServer;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.socketServer.util.SystemUtil;



/*
 * the logic detail when socket connected
 * 
 * 
 * 
 */

public class SocketServerCallableHandler implements Callable<String> {
   
	private Socket so;
	public static Logger logger1 = Logger.getLogger(SocketServerCallableHandler.class);
	public SocketServerCallableHandler(Socket sc)
	{
		so=sc;	
	}


	@Override
	public String call() throws Exception {
		String returnvalue="message summary:";
		try {
			//receive data
			InputStream is;
			is = so.getInputStream();		
	        byte[] data=new byte[1024];
	        
	        if (is.read(data) != -1)
	        {
	        	String outputcontent=new String(data);
	        	logger1.info(SystemUtil.getSystemDate()+"   Server side data received:"+outputcontent);
	        	returnvalue+=outputcontent;
	        }
	              
	        //send data
	        OutputStream os=so.getOutputStream();
	        String finishSignal="all data has been received!!";
	    	logger1.info(finishSignal);
	        os.write(finishSignal.getBytes());

	        is.close();
	        os.close();
	        so.close();
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnvalue;
	}
	

}
