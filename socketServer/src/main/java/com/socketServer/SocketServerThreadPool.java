package com.socketServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.socketServer.util.SystemUtil;


public class SocketServerThreadPool 
{   
	
	private static int port=8091;
	
    public static void main( String[] args ) throws Exception
    {
        ServerSocket ss=new ServerSocket(port);
        System.out.println("server startup at "+port);
        
        ThreadPoolExecutor tpe=new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
       
        while (true)
        {
	        Socket so=ss.accept();
	        System.out.println("client address:"+so.getInetAddress());    
	        tpe.execute(new SocketServerHandler(so));          
        }
        
    }
}
