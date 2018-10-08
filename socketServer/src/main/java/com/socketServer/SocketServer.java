package com.socketServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.socketServer.util.SystemUtil;


public class SocketServer 
{   
	
	private static int port=8091;
	
    public static void main( String[] args ) throws Exception
    {
        ServerSocket ss=new ServerSocket(port);
        System.out.println("server startup at "+port);
        while (true)
        {
	        Socket so=ss.accept();
	        System.out.println("client address:"+so.getInetAddress());
	        
	        
	        
	        //receive data
	        InputStream is=so.getInputStream();
	        byte[] data=new byte[1024];
	        if (is.read(data) != -1)
	        {
	        	String outputcontent=new String(data);
	        	System.out.println(SystemUtil.getSystemDate()+"   Server side data received:"+outputcontent);
	        }
	        
	       
	        //send data
	        OutputStream os=so.getOutputStream();
	        String finishSignal="all data has been received!!";
	        os.write(finishSignal.getBytes());
	        os.flush();
	        
	     
	       
	        is.close();
	        os.close();
	        so.close();
        }
        
    }
}
