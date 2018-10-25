package com.socketServer.multiThread;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.socketServer.util.SystemUtil;



/*
 * the logic detail when socket connected
 * 
 * 
 * 
 */

public class TSHandler implements Runnable {
   
	private int count=0;
	public static Logger logger1 = Logger.getLogger(TSHandler.class);
	public TSHandler()
	{
		
	}
	
	@Override
	public void run() {
		
	
			try {
				count++;
				System.out.println(count);
			} 
			
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	

}
