package com.socketClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.socketClient.util.SystemUtil;

public class SocketClient 
{    private static String host= "192.168.0.160";
     private static int port=8091;
	
    public static void main( String[] args ) throws Exception
    {
          
         Socket so=new Socket(host,port);
         
         //send data
	     OutputStream os=so.getOutputStream();
	     System.out.println("Client side send data!");
         os.write(SystemUtil.getSystemDate().getBytes());
         os.flush();
         
         
         //receive data
         InputStream is=so.getInputStream();
         byte[] data=new byte[1024];
	     if (is.read(data) != -1)
         {
	        	String outputcontent=new String(data);
	        	System.out.println("Client side data received:"+outputcontent);
	     }  
           
        
	     is.close();
	     os.close();
    	 so.close();
    	
    	
    	
    	
    }
}
